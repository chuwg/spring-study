package hellospring.hello.repository;

import hellospring.hello.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 동시성 문제가 있을 수 있어서 공유되는 변수일 때는 ConcurrentHashMap 을 사용해야 하나 예제라서 단순하게 사용
    private static Long sequence = 0L;
    // sequence는 0,1,2 등 키 값을 생성해준다. 동시성 문제를 고려해서 AtomicLong 을 사용해줘야 합니다.
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // null 값이 올수도 있으므로 ofNullable로 해준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        // 자바에서 실무에는 List를 많이 사용한다. < 루프 돌리기가 편함.
        return new ArrayList<>(store.values());
        // store.values = member
    }
}
