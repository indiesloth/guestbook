package org.zerock.guestbook.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PageResultDTO<DTO, EN> {
  private List<DTO> dtoList;

  /*
    Function<T, R> : 객체 T를 객체 R로 변환
   */
  public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {
    dtoList = result.stream().map(fn).collect(Collectors.toList());
  }
}
