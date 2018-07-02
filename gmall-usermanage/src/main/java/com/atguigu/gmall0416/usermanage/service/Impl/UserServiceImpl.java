package com.atguigu.gmall0416.usermanage.service.Impl;

import com.atguigu.gmall0416.usermanage.bean.UserInfo;
import com.atguigu.gmall0416.usermanage.mapper.UserInfoMapper;
import com.atguigu.gmall0416.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public List<UserInfo> getAllUserInfoList(){
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        return userInfos;
    }
    public List<UserInfo> getUserInfoList(UserInfo userInfoQuery){
        List<UserInfo> userInfos=null;
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%"+userInfoQuery.getLoginName()+"%");
        userInfos=userInfoMapper.selectByExample(example);
        return userInfos;
    }
    public UserInfo getUserInfo(UserInfo userInfoQuery){
        UserInfo userInfo=null;
        //按主键查找
        // userInfo = userInfoMapper.selectByPrimaryKey(userInfoQuery.getId());

        //按所有非空值查询   必须只有一行 否则报错
        userInfo = userInfoMapper.selectOne(userInfoQuery );
        return userInfo;
    }

    //增加用户
    public void addUserInfo(UserInfo userInfo){
        //会覆盖数据默认值
        userInfoMapper.insert(userInfo);
        // 不会覆盖数据库默认值
        userInfoMapper.insertSelective(userInfo);
    }


    public void updateUserInfo(UserInfo userInfo){
        //修改用户  依靠主键去查询 ，然后更新其他值，如果某个值为空，那么原值被清空
        //       userInfoMapper.updateByPrimaryKey(userInfo);
        //修改用户  依靠主键去查询 ，然后更新其他不为空的值.
        //        userInfoMapper.updateByPrimaryKeySelective(userInfo);

        //修改用户  依靠自定义条件去修改
        Example example=new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%"+userInfo.getLoginName()+"%");
        userInfo.setLoginName(null);
//        userInfoMapper.updateByExample( userInfo,example );
        userInfoMapper.updateByExampleSelective( userInfo,example );
        //
    }

    public void delete(UserInfo userInfoQuery) {
        userInfoMapper.deleteByPrimaryKey(userInfoQuery.getId());
        //按非空值匹配删除
        //  userInfoMapper.delete(userInfoQuery);
        //按条件匹配删除
        //  userInfoMapper.deleteByExample(new Example(UserInfo.class));
    }
}
