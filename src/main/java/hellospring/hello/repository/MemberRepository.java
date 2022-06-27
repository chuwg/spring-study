package hellospring.hello.repository;

import hellospring.hello.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

    // Optional : java8에서 추가 됨.
    // null을 그대로 반환하지 않고 Optional로 감싸서 반환하는 방법
}
