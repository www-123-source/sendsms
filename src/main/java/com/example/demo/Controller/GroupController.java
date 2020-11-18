package com.example.demo.Controller;



import com.example.demo.Entity.MyGroup;
import com.example.demo.Service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import result.CommonResult;

import java.util.List;

@Api(tags ="分组",description = "group")
@Controller
@RequestMapping("/test")

public class GroupController {
    @Autowired
    private GroupService groupService;

    @ApiOperation("查询用户分组")
    @GetMapping("/group1")
    @ResponseBody
    public List<MyGroup> selectById (int id){return groupService.selectById(id);}

    @ApiOperation("新增分组")
    @PostMapping("/inster2")
    @ResponseBody
    public CommonResult insertGroup (@RequestBody MyGroup myGroup){
        return CommonResult.success(groupService.insertGroup(myGroup));
    }

    @ApiOperation("删除分组")
    @DeleteMapping("/delete2")
    @ResponseBody
    public CommonResult deleteByGroupId (int group_id){
        return CommonResult.success(groupService.deleteByGroupId(group_id));
    }

    @ApiOperation("修改分组")
    @PutMapping("/update2")
    @ResponseBody
    public CommonResult updateByGroupId (@RequestBody MyGroup myGroup){
        return CommonResult.success(groupService.updateByGroupId(myGroup));
    }


}
