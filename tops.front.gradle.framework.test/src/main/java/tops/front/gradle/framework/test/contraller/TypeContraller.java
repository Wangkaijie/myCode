package tops.front.gradle.framework.test.contraller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mapping")
public class TypeContraller {
@RequestMapping("/test")
public String show(){
	return "";
}
}
