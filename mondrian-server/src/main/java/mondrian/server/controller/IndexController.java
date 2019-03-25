package mondrian.server.controller;

/**
 * @author wanghaibing
 * @date 2019-03-06
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String goIndex(){

        return "index";
    }
}
