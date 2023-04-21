package hello.core.member;

public interface MemberService {
    void join(Member memeber);
    Member findMember(Long memberId);
}
