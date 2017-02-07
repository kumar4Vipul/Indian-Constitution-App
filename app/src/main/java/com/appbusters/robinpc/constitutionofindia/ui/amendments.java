package com.appbusters.robinpc.constitutionofindia.ui;

import android.content.Context;
import android.os.Bundle;
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

    public void onClick(View v){

        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        String[] array= {getString(R.string.firstamendment),getString(R.string.secondamendment),getString(R.string.thirdamendment),
                getString(R.string.fourthamendment),getString(R.string.fifthamendment),getString(R.string.sixthamendment),
                getString(R.string.seventhamendment),getString(R.string.eighthamendment),getString(R.string.ninthamendment),
                getString(R.string.tenthamendment),getString(R.string.eleventhamendment),getString(R.string.twelfthamendment),
                getString(R.string.thirteenthamendment),getString(R.string.fourteenthamendment),getString(R.string.fifteenthamendment),
                getString(R.string.sixteenthamendment),getString(R.string.seventeenthamendment),getString(R.string.eighteenthamendment),
                getString(R.string.nineteenthamendment),getString(R.string.twentiethamendment),getString(R.string.twentyfirstamendment),
                getString(R.string.twentysecondamendment),getString(R.string.twentythirdamendment),getString(R.string.twentyfourthamendment),
                getString(R.string.twentyfifthamendment),getString(R.string.twentysixthamendment),getString(R.string.twentyseventhamendment),
                getString(R.string.twentyeighthamendment),getString(R.string.twentyninethamendment),getString(R.string.thirteethamendment),
                getString(R.string.thirtyfirstamendment),getString(R.string.thirtysecondamendment),getString(R.string.thirtythirdamendment),
                getString(R.string.thirtyfourthamendment),getString(R.string.thirtyfifthamendment),getString(R.string.thirtysixthamendment),
                getString(R.string.thirtyseventhamendment),getString(R.string.thirtyeighthamendment),getString(R.string.thirtyninthamendment),
                getString(R.string.fortiethamendment),getString(R.string.fourtyfirstamendment),getString(R.string.fourtysecondamendment),
                getString(R.string.fourtythirdamendment),getString(R.string.fortyfourthamendment),getString(R.string.fortyfifthamendment),
                getString(R.string.fortysixthamendment),getString(R.string.fortyseventhamendment),getString(R.string.fortyeighthamendment),
                getString(R.string.fourtyninthamendment),getString(R.string.fiftiethamendment),getString(R.string.fiftyfirstamendment),
                getString(R.string.fiftysecondamendment),getString(R.string.fiftythirdamendment),getString(R.string.fiftyfourthamendment),
                getString(R.string.fiftyfifthamendment),getString(R.string.fiftysixthamendment),getString(R.string.fiftyseventhamendment),
                getString(R.string.fiftyeighthamendment),getString(R.string.fiftyninthamendment),getString(R.string.sixtiethamendment),
                getString(R.string.sixtyfirstamendment),getString(R.string.sixtysecondamendment),getString(R.string.sixtythirdamendment),
                getString(R.string.sixtyfourthamendment),getString(R.string.sixtyfifthamendment),getString(R.string.sixtysixthamendment),
                getString(R.string.sixtyseventhamendment),getString(R.string.sixtyeighthamendment),getString(R.string.sixtyninthamendment),
                getString(R.string.seventiethamendment),getString(R.string.seventyfirstamendment),getString(R.string.seventysecondamendment),
                getString(R.string.seventythirdamendment),getString(R.string.seventyfourthamendment),getString(R.string.seventyfifthamendment),
                getString(R.string.seventysixthamendment),getString(R.string.seventyseventhamendment),getString(R.string.seventyeighthamendment),
                getString(R.string.seventyninthamendment),getString(R.string.eightiethamendment),getString(R.string.eightyfirstamendment),
                getString(R.string.eightysecondamendment),getString(R.string.eightythirdamendment),getString(R.string.eightyfourthamendment),
                getString(R.string.eightyfifthamendment),getString(R.string.eightysixthamendment),getString(R.string.eightyseventhamendment),
                getString(R.string.eightyeighthamendment),getString(R.string.eightyninthamendment),getString(R.string.hundredthamendment)};

        switch (v.getId()){
            case R.id.a1:
            {
                alert.setMessage(array[0]).setTitle("Amendment - 1").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a2:
            {
                alert.setMessage(array[1]).setTitle("Amendment - 2").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a3:
            {
                alert.setMessage(array[2]).setTitle("Amendment - 3").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a4:
            {
                alert.setMessage(array[3]).setTitle("Amendment - 4").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a5:
            {
                alert.setMessage(array[4]).setTitle("Amendment - 5").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a6:
            {
                alert.setMessage(array[5]).setTitle("Amendment - 6").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a7:
            {
                alert.setMessage(array[6]).setTitle("Amendment - 7").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a8:
            {
                alert.setMessage(array[7]).setTitle("Amendment - 8").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a9:
            {
                alert.setMessage(array[8]).setTitle("Amendment - 9").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a10:
            {
                alert.setMessage(array[9]).setTitle("Amendment - 10").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a11:
            {
                alert.setMessage(array[10]).setTitle("Amendment - 11").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a12:
            {
                alert.setMessage(array[11]).setTitle("Amendment - 12").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a13:
            {
                alert.setMessage(array[12]).setTitle("Amendment - 13").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a14:
            {
                alert.setMessage(array[13]).setTitle("Amendment - 14").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a15:
            {
                alert.setMessage(array[14]).setTitle("Amendment - 15").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a16:
            {
                alert.setMessage(array[15]).setTitle("Amendment - 16").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a17:
            {
                alert.setMessage(array[16]).setTitle("Amendment - 17").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a18:
            {
                alert.setMessage(array[17]).setTitle("Amendment - 18").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a19:
            {
                alert.setMessage(array[18]).setTitle("Amendment - 19").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a20:
            {
                alert.setMessage(array[19]).setTitle("Amendment - 20").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a21:
            {
                alert.setMessage(array[20]).setTitle("Amendment - 21").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a22:
            {
                alert.setMessage(array[21]).setTitle("Amendment - 22").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a23:
            {
                alert.setMessage(array[22]).setTitle("Amendment - 23").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a24:
            {
                alert.setMessage(array[23]).setTitle("Amendment - 24").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a25:
            {
                alert.setMessage(array[24]).setTitle("Amendment - 25").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a26:
            {
                alert.setMessage(array[25]).setTitle("Amendment - 26").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a27:
            {
                alert.setMessage(array[26]).setTitle("Amendment - 27").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a28:
            {
                alert.setMessage(array[27]).setTitle("Amendment - 28").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a29:
            {
                alert.setMessage(array[28]).setTitle("Amendment - 29").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a30:
            {
                alert.setMessage(array[29]).setTitle("Amendment - 30").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a31:
            {
                alert.setMessage(array[30]).setTitle("Amendment - 31").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a32:
            {
                alert.setMessage(array[31]).setTitle("Amendment - 32").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a33:
            {
                alert.setMessage(array[32]).setTitle("Amendment - 33").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a34:
            {
                alert.setMessage(array[33]).setTitle("Amendment - 34").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a35:
            {
                alert.setMessage(array[34]).setTitle("Amendment - 35").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a36:
            {
                alert.setMessage(array[35]).setTitle("Amendment - 36").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a37:
            {
                alert.setMessage(array[36]).setTitle("Amendment - 37").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a38:
            {
                alert.setMessage(array[37]).setTitle("Amendment - 38").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a39:
            {
                alert.setMessage(array[38]).setTitle("Amendment - 39").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a40:
            {
                alert.setMessage(array[39]).setTitle("Amendment - 40").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a41:
            {
                alert.setMessage(array[40]).setTitle("Amendment - 41").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a42:
            {
                alert.setMessage(array[41]).setTitle("Amendment - 42").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a43:
            {
                alert.setMessage(array[42]).setTitle("Amendment - 43").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a44:
            {
                alert.setMessage(array[43]).setTitle("Amendment - 44").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a45:
            {
                alert.setMessage(array[44]).setTitle("Amendment - 45").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a46:
            {
                alert.setMessage(array[45]).setTitle("Amendment - 46").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a47:
            {
                alert.setMessage(array[46]).setTitle("Amendment - 47").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a48:
            {
                alert.setMessage(array[47]).setTitle("Amendment - 48").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a49:
            {
                alert.setMessage(array[48]).setTitle("Amendment - 49").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a50:
            {
                alert.setMessage(array[49]).setTitle("Amendment - 50").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a51:
            {
                alert.setMessage(array[50]).setTitle("Amendment - 51").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a52:
            {
                alert.setMessage(array[51]).setTitle("Amendment - 52").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a53:
            {
                alert.setMessage(array[52]).setTitle("Amendment - 53").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a54:
            {
                alert.setMessage(array[53]).setTitle("Amendment - 54").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a55:
            {
                alert.setMessage(array[54]).setTitle("Amendment - 55").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a56:
            {
                alert.setMessage(array[55]).setTitle("Amendment - 56").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a57:
            {
                alert.setMessage(array[56]).setTitle("Amendment - 57").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a58:
            {
                alert.setMessage(array[57]).setTitle("Amendment - 58").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a59:
            {
                alert.setMessage(array[58]).setTitle("Amendment - 59").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a60:
            {
                alert.setMessage(array[59]).setTitle("Amendment - 60").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a61:
            {
                alert.setMessage(array[60]).setTitle("Amendment - 61").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a62:
            {
                alert.setMessage(array[61]).setTitle("Amendment - 62").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a63:
            {
                alert.setMessage(array[62]).setTitle("Amendment - 63").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a64:
            {
                alert.setMessage(array[63]).setTitle("Amendment - 64").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a65:
            {
                alert.setMessage(array[64]).setTitle("Amendment - 65").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a66:
            {
                alert.setMessage(array[65]).setTitle("Amendment - 66").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a67:
            {
                alert.setMessage(array[66]).setTitle("Amendment - 67").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a68:
            {
                alert.setMessage(array[67]).setTitle("Amendment - 68").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a69:
            {
                alert.setMessage(array[68]).setTitle("Amendment - 69").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a70:
            {
                alert.setMessage(array[69]).setTitle("Amendment - 70").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a71:
            {
                alert.setMessage(array[70]).setTitle("Amendment - 71").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a72:
            {
                alert.setMessage(array[71]).setTitle("Amendment - 72").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a73:
            {
                alert.setMessage(array[72]).setTitle("Amendment - 73").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a74:
            {
                alert.setMessage(array[73]).setTitle("Amendment - 74").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a75:
            {
                alert.setMessage(array[74]).setTitle("Amendment - 75").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a76:
            {
                alert.setMessage(array[75]).setTitle("Amendment - 76").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a77:
            {
                alert.setMessage(array[76]).setTitle("Amendment - 77").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a78:
            {
                alert.setMessage(array[77]).setTitle("Amendment - 78").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a79:
            {
                alert.setMessage(array[78]).setTitle("Amendment - 79").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a80:
            {
                alert.setMessage(array[79]).setTitle("Amendment - 80").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a81:
            {
                alert.setMessage(array[80]).setTitle("Amendment - 81").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a82:
            {
                alert.setMessage(array[81]).setTitle("Amendment - 82").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a83:
            {
                alert.setMessage(array[82]).setTitle("Amendment - 83").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a84:
            {
                alert.setMessage(array[83]).setTitle("Amendment - 84").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a85:
            {
                alert.setMessage(array[84]).setTitle("Amendment - 85").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a86:
            {
                alert.setMessage(array[85]).setTitle("Amendment - 86").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a87:
            {
                alert.setMessage(array[86]).setTitle("Amendment - 87").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a88:
            {
                alert.setMessage(array[87]).setTitle("Amendment - 88").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a89:
            {
                alert.setMessage(array[88]).setTitle("Amendment - 89").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a90:
            {
                alert.setMessage(array[89]).setTitle("Amendment - 90").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a91:
            {
                alert.setMessage(array[90]).setTitle("Amendment - 91").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a92:
            {
                alert.setMessage(array[91]).setTitle("Amendment - 92").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a93:
            {
                alert.setMessage(array[92]).setTitle("Amendment - 93").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a94:
            {
                alert.setMessage(array[93]).setTitle("Amendment - 94").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a95:
            {
                alert.setMessage(array[94]).setTitle("Amendment - 95").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a96:
            {
                alert.setMessage(array[95]).setTitle("Amendment - 96").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a97:
            {
                alert.setMessage(array[96]).setTitle("Amendment - 97").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a98:
            {
                alert.setMessage(array[97]).setTitle("Amendment - 98").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a99:
            {
                alert.setMessage(array[98]).setTitle("Amendment - 99").setIcon(R.drawable.dialog).create().show();
                break;
            }
            case R.id.a100:
            {
                alert.setMessage(array[99]).setTitle("Amendment - 100").setIcon(R.drawable.dialog).create().show();
                break;
            }
        }
    }

}

