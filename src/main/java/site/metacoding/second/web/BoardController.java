package site.metacoding.second.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.second.dto.req.BoardReqDto.BoardSaveReqDto;
import site.metacoding.second.dto.resp.ResponseDto;
import site.metacoding.second.dto.resp.BoardRespDto.BoardListRespDto;
import site.metacoding.second.dto.resp.BoardRespDto.BoardSaveRespDto;
import site.metacoding.second.service.BoardService;

@RequiredArgsConstructor
@RestController
public class BoardController {

  final BoardService boardService;

  @PostMapping("/board")
  public ResponseDto<?> save(@RequestBody BoardSaveReqDto boardSaveReqDto) {
    BoardSaveRespDto boardSaveRespDto = boardService.save(boardSaveReqDto);
    return new ResponseDto<>(1, "게시글 등록", boardSaveRespDto);
  }

  @GetMapping("/board")
  public ResponseDto<?> findAll() {
    List<BoardListRespDto> boardListRespDtoList = boardService.findAll();
    return new ResponseDto<>(1, "게시글 목록", boardListRespDtoList);
  }

}
