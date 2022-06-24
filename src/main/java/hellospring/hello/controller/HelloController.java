package hellospring.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!! 되나요?");
        return "Hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        // model에 담으면 View에서 렌더해서 사용
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http body부에 직접 이 내용을 넣어주겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
        // 파라미터에 string 이라고 넣으면 "hello string" 이라고 뜬다.
        // 이 때 소스보기를 해보면 html 형식이 아니라 정말 텍스트만 뿌려주는걸 볼 수 있다.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}