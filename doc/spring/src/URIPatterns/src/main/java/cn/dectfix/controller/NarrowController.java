package cn.dectfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huqian on 2017/12/11.
 */
@Controller
@RequestMapping("narrow")
public class NarrowController {

    /*
     *
     */
    @PostMapping(path = "/pets0", consumes = "application/json")
    @ResponseBody
    public String addPet(@RequestBody String petInfo) {
        return "Consumes Limit#"+petInfo;
    }

    /*
     * Use produces could control the content type of response. Here uses application/json tell it must be json.
     * Also you could use other types.
     *
     */
    @GetMapping(path = "/pets1_1/{petId}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getPet1(@PathVariable String petId) {
        return "Produces Limit#"+petId;
    }

    @GetMapping(path = "/pets1_2/{petId}", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getPet2(@PathVariable String petId) {
        return "{\"name\":\"pig\",\"age\":9}";
    }


    /*
     *
     */
    @GetMapping(path = "/pets2/{petId}")
    @ResponseBody
    public String findPetWithoutParamLimit(@PathVariable String petId) {
        return "Without Param limit#"+petId;
    }

    @GetMapping(path = "/pets2/{petId}", params = "personInfo=true")
    @ResponseBody
    public String findPet(@PathVariable String petId) {
        return "Param limit#"+petId;
    }

    @RequestMapping(path = "/pets3/{petId}", headers = "host=localhost:8080")
    @ResponseBody
    public String findPet2(@PathVariable String petId) {
        return "Default Header#"+petId;
    }

}
