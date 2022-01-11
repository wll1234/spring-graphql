package com.example.springgraphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.springgraphql.domain.Member;
import com.example.springgraphql.domain.Role;
import com.example.springgraphql.dto.MemberDto;
import com.example.springgraphql.repository.MemberRepository;
import com.example.springgraphql.repository.RoleRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Transactional
public class MemberMutation implements GraphQLMutationResolver {

  private final MemberRepository memberRepository;

  private final RoleRepository roleRepository;

  public MemberDto createMember(MemberDto memberDto) {
    Member member = memberRepository.save(Member.builder()
        .loginId(memberDto.getLoginId())
        .name(memberDto.getName())
        .password(memberDto.getPassword())
        .build());
    return MemberDto.from(member);
  }

  public Boolean deleteMember(int id){
    Optional<Member> optionalMember = memberRepository.findById(id);
    Role role = roleRepository.findByMemberId(id);
    if(optionalMember.isPresent()) {
      roleRepository.delete(role);
      memberRepository.delete(optionalMember.get());
    }
    return true;
  }
}
