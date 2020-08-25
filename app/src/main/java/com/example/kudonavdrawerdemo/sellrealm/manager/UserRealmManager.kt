package com.example.kudonavdrawerdemo.sellrealm.manager

import com.example.kudonavdrawerdemo.model.User
import com.example.kudonavdrawerdemo.sellrealm.realmitf.SellUserManager
import io.realm.Realm

class UserManager : SellUserManager {
    override fun addUser(realm: Realm, user: User) {
        try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(user)
            realm.commitTransaction()
        } catch (e: Exception) {
            print(e)
        }
    }

    override fun editUser(realm: Realm, user: User) {
        try {
            realm.beginTransaction()
            realm.copyToRealmOrUpdate(user)
            realm.commitTransaction()
        } catch (e: Exception) {
            print(e)
        }
    }
}