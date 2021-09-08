package com.kortikoedu.kortiko.data.helper

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast

/** For Make Toast a View */
fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

/** For Make alert Dialog a View */
fun Context.alertDialog(
    msg: String,
    listener: DialogInterface.OnClickListener
) {
    val alert = AlertDialog.Builder(this)
    alert.setTitle("Apakah Anda Yakin ?")
    alert.setMessage(msg)
    alert.setPositiveButton(
        "Ya", listener
    )
    alert.setNegativeButton(
        "Tidak", null
    )
    val alertDialog = alert.create()
    alertDialog.show()
}