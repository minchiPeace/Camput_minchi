package camput.Service;

import camput.Dto.loginApiDto.LoginSessionDto;
import camput.Dto.loginApiDto.MemberResponseDto;
import camput.Dto.loginApiDto.SocialAuthResponse;
import camput.domain.Member;
import camput.domain.MemberGender;
import camput.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoLoginService {
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final LoginApiService loginApiService;

    public HttpSession doApiLogin(String code,HttpSession session, HttpServletRequest request){
        SocialAuthResponse accessToken = loginApiService.getAccessToken(code);
        MemberResponseDto userInfo = loginApiService.getUserInfo(accessToken.getAccess_token());
        MemberGender gender;
        if (userInfo.getLoginId().isEmpty()){
            throw new IllegalArgumentException("이메일이 없으면 로그인이 불가능합니다");
        }

        if(memberRepository.findByMemberLoginId(userInfo.getLoginId())==null){
            if(userInfo.getGender()=="male"){
                gender=MemberGender.MALE;
            }else if(userInfo.getGender()=="female"){
                gender=MemberGender.FEMALE;
            }else{
                gender=null;
            }
            Member member = Member.builder()
                    .memberLoginId(userInfo.getLoginId())
                    .birthday(userInfo.getBirthday())
                    .nickName(userInfo.getNickname())
                    .memberPoint("1000000")
                    .memberName(userInfo.getNickname())
                    .gender(gender)
                    .build();
            memberRepository.save(member);
        }
        Member member = memberRepository.findByMemberLoginId(userInfo.getLoginId());

        if(member==null){
            throw new IllegalArgumentException("없는 회원 입니다");
        }
        String loginId = userInfo.getLoginId();

        LoginSessionDto loginSession = LoginSessionDto.builder()
                .loginCode(accessToken.getAccess_token())
                .loginId(loginId)
                .build();

        session = request.getSession();
        session.setAttribute(memberService.LOGIN_MEMBER, loginSession);
     return session;
    }

}
