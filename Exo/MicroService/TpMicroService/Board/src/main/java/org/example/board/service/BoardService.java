package org.example.board.service;

import org.example.board.dto.BoardDtoReceive;
import org.example.board.dto.BoardDtoResponse;
import org.example.board.dto.User;
import org.example.board.exceptions.BoardFullException;
import org.example.board.exceptions.NotFoundException;
import org.example.board.exceptions.NotOwnerException;
import org.example.board.exceptions.UserAlreadyInBoardException;
import org.example.board.models.Board;
import org.example.board.models.UserInBoard;
import org.example.board.repository.BoardRepository;
import org.example.board.repository.UserInBoardRepository;
import org.example.board.tools.RestClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private BoardRepository repository;
    private UserInBoardRepository repositoryUser;
    private RestClient<User> userClient;

    public BoardService(BoardRepository repository, UserInBoardRepository repositoryUser) {
        this.repository = repository;
        this.repositoryUser =repositoryUser;
        userClient = new RestClient<>("http://localhost:8081/api/user/");
    }

    public BoardDtoResponse addBoard (BoardDtoReceive receive){
        User user = userClient.getRequest(User.class,receive.getIdUserOwner()+"");
        if(user != null){
            Board board = dtoToEntity(receive);
            UserInBoard userInBoard = new UserInBoard(board.getIdUserOwner());
            repositoryUser.save(userInBoard);
            board.addMenber(userInBoard);
            return entityToDto(repository.save(board));
        }
        throw new NotFoundException("id :"+receive.getIdUserOwner()+" not found");
    }

    public BoardDtoResponse addMemberToBoard (int idOwner,int idUser,int idBoard){
        User user = userClient.getRequest(User.class,idUser+"");
        if(user != null){
           Board board = repository.findById(idBoard).orElseThrow(NotFoundException::new);
           if(idOwner == board.getIdUserOwner()){
               if(board.getMaxMember() > board.getMembers().size()){
                   if(board.getMembers().contains(new UserInBoard(idUser))){
                       throw new UserAlreadyInBoardException();
                   }
                   UserInBoard userInBoard = new UserInBoard(idUser);
                   repositoryUser.save(userInBoard);
                   board.addMenber(userInBoard);
                   repository.save(board);
                   return entityToDto(board);
               }
               throw new BoardFullException("board with id: "+idBoard+" is full");
           }
           throw new NotOwnerException("Owner id : "+idOwner+" is not owner of the board id : "+idBoard);
        }
        throw new NotFoundException("id :"+idUser+" not found");
    }

    public List<BoardDtoResponse> getBoardFromUser (int idUser ){
        Optional<UserInBoard> user = repositoryUser.findById(idUser);
        if(user.isPresent()){
            List<BoardDtoResponse> boardDtoResponses = new ArrayList<>();
            for (Board board : user.get().getBoards()){
                boardDtoResponses.add(entityToDto(board));
            }
            return boardDtoResponses;
        }
        throw new NotFoundException();

    }

    public BoardDtoResponse getById (int idBoard){
        return entityToDto(repository.findById(idBoard).orElseThrow(NotFoundException::new));
    }

    private Board dtoToEntity (BoardDtoReceive dtoReceive){
        return Board.builder()
                .name(dtoReceive.getName())
                .idUserOwner(dtoReceive.getIdUserOwner())
                .maxMember(dtoReceive.getMaxMember())
                .members(new ArrayList<>())
                .build();
    }

    private BoardDtoResponse entityToDto (Board board){
        BoardDtoResponse response = BoardDtoResponse.builder()
                .id(board.getId())
                .name(board.getName())
                .maxMember(board.getMaxMember())
                .build();

        response.setUserOwner(userClient.getRequest(User.class,board.getIdUserOwner()+""));
        List<User> userMember = new ArrayList<>();
        for ( UserInBoard user : board.getMembers()){
            userMember.add(userClient.getRequest(User.class,user.getIdUser()+""));
        }
        response.setMember(userMember);

        return response;
    }
}
