package com.example.demo.Servicelmpl;

import com.example.demo.Entity.MyGroup;
import com.example.demo.Mapper.GroupMapper;
import com.example.demo.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServicelmpl implements GroupService {

@Autowired
private GroupMapper groupMapper;


    @Override
    public List<MyGroup> selectById(int id) {return groupMapper.selectById(id);}

    @Override
    public int insertGroup(MyGroup myGroup) {
        return groupMapper.insertGroup(myGroup);
    }

    @Override
    public int deleteByGroupId(int group_id){
        return groupMapper.deleteByGroupId(group_id);
    }

    @Override
    public int updateByGroupId(MyGroup myGroup) {return groupMapper.updateByGroupId(myGroup);}
}
