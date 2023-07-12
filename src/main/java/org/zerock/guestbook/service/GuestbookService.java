package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;

public interface GuestbookService {

  Long register(GuestbookDTO dto);

  PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);

  /* java8버전부터 인터페이스에 실제 내용을 가지는 코드를 default 키워드로
    생성할 수 있다. 이를 이용하면 추상 클래스를 통해서 전달해야 하는 실제 코드를
    인터페이스에 선언할 수 있다.
  */
  default Guestbook dtoToEntity(GuestbookDTO dto) {
    Guestbook entity = Guestbook.builder()
        .gno(dto.getGno())
        .title(dto.getTitle())
        .content(dto.getContent())
        .writer(dto.getWriter())
        .build();
    return entity;
  }

  default GuestbookDTO entityToDto(Guestbook entity) {
    GuestbookDTO dto = GuestbookDTO.builder()
        .gno(entity.getGno())
        .title(entity.getTitle())
        .content(entity.getContent())
        .writer(entity.getWriter())
        .regDate(entity.getRegDate())
        .modDate(entity.getModDate())
        .build();
    return dto;
  }
}
