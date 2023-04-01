package camput.Dto;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@NoArgsConstructor // 기본생성자 자동 생성
@ToString   // 출력할때
public class MemberJoinDto {

private String memberEmail;
private String birthday;
private String memberName;
private String gender;
private String streetAddress;
private String mainAddress;
private String memberPostNum;
private String detailAddress;
private String extraAddress;
private String memberLoginId;
private String phoneNumber;
private String memberPassword;
private String nickName;
private String memberPoint;
private Long id;
private String memberPasswordHidden;

@Builder
    public MemberJoinDto(String memberName, String phoneNumber, String memberEmail, String birthday, String gender, String streetAddress, String mainAddress, String memberPostNum, String detailAddress, String extraAddress, String memberLoginId, String memberPassword, String nickName, String memberPoint, long id, String memberPasswordHidden) {
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
        this.memberEmail = memberEmail;
        this.birthday = birthday;
        this.gender = gender;
        this.streetAddress = streetAddress;
        this.mainAddress = mainAddress;
        this.memberPostNum = memberPostNum;
        this.detailAddress = detailAddress;
        this.extraAddress = extraAddress;
        this.memberLoginId = memberLoginId;
        this.memberPassword = memberPassword;
        this.nickName = nickName;
        this.memberPoint = memberPoint;
        this.id = id;
        this.memberPasswordHidden = memberPasswordHidden;
    }
}
