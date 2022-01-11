package com.example.springgraphql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.springgraphql.domain.Member;
import com.example.springgraphql.dto.MemberDto;
import com.example.springgraphql.repository.MemberRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Transactional
public class MemberQuery implements GraphQLQueryResolver {

  private final MemberRepository memberRepository;

  public MemberDto getMember(int id) {
    Member member = memberRepository.findById(id)
        .orElse(null);
    return MemberDto.from(member);
  }
}