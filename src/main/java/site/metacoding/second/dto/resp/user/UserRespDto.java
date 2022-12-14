package site.metacoding.second.dto.resp.user;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.second.domain.User;

public class UserRespDto {

  @Setter
  @Getter
  public static class UserJoinRespDto {
    private String username;
    private String password;
    private String email;

    public UserJoinRespDto(User user) {
      this.username = user.getUsername();
      this.password = user.getPassword();
      this.email = user.getEmail();
    }
  }

}
