package com.example.kudonavdrawerdemo.sellrealm.realmitf

import com.example.kudonavdrawerdemo.model.Pro
import io.realm.Realm

interface BoughtManager {
    fun addBought(realm: Realm,product:Pro)
    fun delBought(realm: Realm,product: Pro)
}