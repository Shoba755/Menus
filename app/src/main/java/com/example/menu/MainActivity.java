package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ActionMode mActionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Context Menu

        TextView textView = findViewById(R.id.text_view);
        registerForContextMenu(textView);

        // and Contextual action mode

        TextView textView1 = findViewById(R.id.text_view2);
        textView1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mActionMode != null){
                    return false;
                }

                mActionMode = startSupportActionMode(mActionModecallback);
                return true;
            }
        });
    }


    private ActionMode.Callback mActionModecallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.actionmode_menu,menu);
            mode.setTitle("Choose your option");
            return false;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.option1:
                    Toast.makeText(MainActivity.this, "Option 1 selected", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.option2:
                    Toast.makeText(MainActivity.this, "Option 2 selected", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.option3:
                    Toast.makeText(MainActivity.this, "Option 3 selected", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.option4:
                    Toast.makeText(MainActivity.this, "Option 4 selected", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    // Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.c1){
            Toast.makeText(this, "Happy Raksha Bandhan", Toast.LENGTH_SHORT).show();
        }else if(id== R.id.c2){
            Toast.makeText(this, "Happy Friendship Day", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.c3){
            Toast.makeText(this, "Happy Enemy Day", Toast.LENGTH_SHORT).show();
        }else{
            finish();
        }
        return super.onContextItemSelected(item);
    }

    // Options menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optional_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "You Clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "You Clicked Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "You Clicked Sign out", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                Toast.makeText(this, "yes you clicked on siri", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sub1:
                Toast.makeText(this, "Internal settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sub2:
                Toast.makeText(this, "External Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    // popup menu
    public void showPopUp(View view) {


        PopupMenu popup = new PopupMenu(this,view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    public boolean onMenuItemClick(MenuItem item){
        switch(item.getItemId()){
            case R.id.one:
                Toast.makeText(this, "clicked on Cse", Toast.LENGTH_SHORT).show();
                break;
            case R.id.two:
                Toast.makeText(this, "clicked on Ece", Toast.LENGTH_SHORT).show();
                break;
            default:
                return false;
        }
        return true;
    }

}