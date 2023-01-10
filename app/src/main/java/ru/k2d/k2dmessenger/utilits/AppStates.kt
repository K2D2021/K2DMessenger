package ru.k2d.k2dmessenger.utilits

import ru.k2d.k2dmessenger.database.*

enum class AppStates(val state: String) {
    ONLINE("Online"),
    OFFLINE("Offline"),
    TYPING("Typing");

    companion object {
        fun updateState(appStates: AppStates) {
            if (AUTH.currentUser != null){
            REF_DATABASE_ROOT.child(NODE_USERS).child(CURRENT_UID).child(CHILD_STATE)
                .setValue(appStates.state)
                .addOnSuccessListener { USER.state = appStates.state }
                .addOnFailureListener { showToast(it.message.toString()) }
            }
        }
    }
}