package com.githinjiHans.chatapp

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.githinjiHans.chatapp.databinding.ActivitySetupProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class SetupProfileActivity : AppCompatActivity() {

    var binding: ActivitySetupProfileBinding? = null
    var auth:FirebaseAuth? = null
    var database:FirebaseDatabase? = null
    var storage:FirebaseStorage? = null
    var selectedImage: Uri? = null
    var dialog:ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetupProfileBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        dialog!!.setMessage("Updating Profile...")
        dialog!!.setCancelable(false)
        storage = FirebaseStorage.getInstance()
        auth = FirebaseAuth.getInstance()
        supportActionBar?.hide()
        binding!!.imageView.setOnClickListener{
            val intent = Intent()
            intent.action  = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            startActivityForResult(intent, 45)

        }
        binding!!.continueBtn1.setOnClickListener{
            val name : String = binding!!.nameContainer.toString()
            if (name.isEmpty()) {
                binding!!.nameContainer.setError("Please enter a name")
            }
            dialog!!.show()
            if (selectedImage != null) {
                val reference = storage!!.reference.child("Profile")
                    .child(auth!!.uid!!)
            }
        }
    }
}