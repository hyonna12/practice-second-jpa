package site.metacoding.second.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.second.domain.Board;
import site.metacoding.second.domain.BoardRepository;
import site.metacoding.second.dto.req.BoardReqDto.BoardSaveReqDto;
import site.metacoding.second.dto.resp.BoardRespDto.BoardListRespDto;
import site.metacoding.second.dto.resp.BoardRespDto.BoardSaveRespDto;

@RequiredArgsConstructor
@Service
public class BoardService {

  final BoardRepository boardRepository;

  @Transactional
  public BoardSaveRespDto save(BoardSaveReqDto boardSaveReqDto) {
    Board boardPS = boardRepository.save(boardSaveReqDto.toEntity());
    BoardSaveRespDto boardSaveRespDto = new BoardSaveRespDto(boardPS);
    return boardSaveRespDto;
  }

  @Transactional
  public List<BoardListRespDto> findAll() {
    List<Board> boardList = boardRepository.findAll();
    List<BoardListRespDto> boardListRespDtoList = new ArrayList<>();
    for (Board board : boardList) {
      boardListRespDtoList.add(new BoardListRespDto(board));
    }
    return boardListRespDtoList;
  }

}