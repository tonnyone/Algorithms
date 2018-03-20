package com.tonny.dao;

import com.tonny.po.User;
import org.apache.catalina.realm.JNDIRealm;

/**
 * Created by tonny on 2016/10/17.
 */
public interface UserDao {
    User selectById(int id);
}
