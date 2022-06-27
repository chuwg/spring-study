package hellospring.hello.domain;

public class Member {
    private Long id; // 시스템이 저장하는 임의의 값 입니다. 고객이 정하는게 아님!
    private String name;

    // 단순하게 만들기 때문에 Getter Setter를 사용합니다.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
