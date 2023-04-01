package camput.controller;

import camput.Dto.MyPageCampDto;
import camput.Service.LoginCheckService;
import camput.Service.MemberService;
import camput.Service.MyPageLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("camput/")
@RequiredArgsConstructor
@Slf4j
public class MyPageLikeController {
    private final MyPageLikeService myPageLikeService;
    private final MemberService memberService;
    private final LoginCheckService loginCheckService;

    @GetMapping("myPage/like")
    public String myPageLike(Model model, Pageable pageable, HttpServletRequest request){
        String loginId = loginCheckService.checkLogin(request);
        String memberNickName = memberService.findMemberNickName(loginId);
        Page<MyPageCampDto> myPageCampDtos = myPageLikeService.likeCamps(loginId,pageable);
        Page<MyPageCampDto> content = myPageCampDtos;
        int totalPage= myPageCampDtos.getTotalPages()-1;

        model.addAttribute("memberNickName",memberNickName);
        model.addAttribute("likeCamps",content);
        model.addAttribute("totalPage",totalPage);
        return "/myPageLike";
    }
}
