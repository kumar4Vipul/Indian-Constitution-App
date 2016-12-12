package com.appbusters.robinpc.constitutionofindia.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.appbusters.robinpc.constitutionofindia.R;

public class amendments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amendments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void buttonOnClick(View v){

        Context context=getApplicationContext();
        CharSequence[] text={ "BETA Config. : Favourites","BETA Config. : Search","BETA Config. : Share",
                "BETA Config. : Notes"};

        switch (v.getId())
        {
            case R.id.fabL2:
            {
                Toast.makeText(context,text[0],Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.fabL:
            {
                Toast.makeText(context,text[1],Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.fabR:
            {
                Toast.makeText(context,text[2],Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.fabR2:
            {
                Toast.makeText(context,text[3],Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    public void onClick(View v){

        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        String[] array= {getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment),
                getString(R.string.firstamendment),getString(R.string.firstamendment),getString(R.string.firstamendment)};

        switch (v.getId()){
            case R.id.a1:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a2:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a3:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a4:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a5:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a6:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a7:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a8:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a9:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a10:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a11:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a12:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a13:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a14:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a15:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a16:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a17:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a18:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a19:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a20:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a21:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a22:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a23:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a24:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a25:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a26:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a27:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a28:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a29:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a30:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a31:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a32:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a33:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a34:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a35:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a36:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a37:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a38:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a39:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a40:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a41:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a42:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a43:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a44:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a45:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a46:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a47:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a48:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a49:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a50:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a51:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a52:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a53:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a54:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a55:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a56:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a57:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a58:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a59:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a60:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a61:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a62:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a63:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a64:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a65:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a66:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a67:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a68:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a69:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a70:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a71:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a72:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a73:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a74:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a75:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a76:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a77:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a78:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a79:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a80:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a81:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a82:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a83:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a84:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a85:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a86:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a87:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a88:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a89:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a90:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a91:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a92:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a93:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a94:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a95:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a96:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a97:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a98:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a99:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a100:
            {
                alert.setMessage(array[0]).setTitle("First Amendment").setIcon(R.drawable.dialog).create().show();
                break;
            }
        }
    }

}

