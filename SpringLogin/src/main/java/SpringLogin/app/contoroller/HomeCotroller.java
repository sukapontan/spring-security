package SpringLogin.app.contoroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import SpringLogin.app.model.User;
import SpringLogin.app.service.UserService;

@Controller
public class HomeCotroller {

	// インスタンスを作成しDIコンテナに格納。
    @Autowired
    UserService userService;

    //userListのアドレスにアクセスした際にGetメソッドを実行。
    @GetMapping("/userList")
    public String getUserList(Model model) {

        //@Autowiredで作成したインスタンスを元に、userServiceのメソッドを呼び出す。
        List<User> userList = userService.selectMany();
        //userServiceから受け取ったデータをView側に渡す。
        model.addAttribute("userList", userList);

        //template配下のファイル名を指定することでViewを呼び出せる。
        return "userList";
	}

}
