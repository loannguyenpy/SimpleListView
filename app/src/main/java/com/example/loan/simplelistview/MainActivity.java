package com.example.loan.simplelistview;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   public enum ButtonFormat{
        ADD (0), EDIT(1);
        public   int value =0;
       ButtonFormat(int value){
           this.value = value;
       }
       public int getValue(){
           return value;
       }
    }
    private TextView mTextTitle;
    ListviewAdapter listviewAdapter;
    Student student=null;
    EditText mEditTextName;
    EditText mEditTextAge;
    EditText mEditTextCountry;
    EditText mEditTextGender;
    Button mAdd;
    ButtonFormat buttonFormat = ButtonFormat.ADD;
    ListView listView;
    private View mViewHolder = null;
    private int mPosition=0;
   public final List<Student> studentList = new ArrayList<>();
    //Cái view mình muốn lấy đặt nó ở đây đã, chưa tóm được tên nào thì nó null

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //

        listView = (ListView) findViewById(R.id.listview);
        mTextTitle = (TextView) findViewById(R.id.textTitle);

        mEditTextName = (EditText) findViewById(R.id.edutTextName);
        mEditTextAge = (EditText) findViewById(R.id.edutTextAge);
        mEditTextCountry = (EditText) findViewById(R.id.edutTextCountry);
        mEditTextGender = (EditText) findViewById(R.id.edutTextGender);
        mAdd = (Button) findViewById(R.id.buttonAdd);



        studentList.add(new Student("Nguyễn A", 23, "Cà Mau", "Nam"));
        studentList.add(new Student("Nguyễn B", 21, "Hà Nam", "Nữ"));
        studentList.add(new Student("Nguyễn C", 23, "Bạc Liêu", "Nữ"));
        studentList.add(new Student("Nguyễn D", 13, "Vũng Tàu", "Nam"));
        studentList.add(new Student("Nguyễn E", 23, "Cà Mau", "Nữ"));
        studentList.add(new Student("Nguyễn F", 29, "Cà Mau", "Nam"));
        studentList.add(new Student("Nguyễn G", 22, "Cà Mau", "Nam"));
        studentList.add(new Student("Nguyễn H", 23, "Cà Mau", "Nam"));
        studentList.add(new Student("Nguyễn I", 20, "Cà Mau", "Nam"));
        studentList.add(new Student("Nguyễn J", 21, "Cà Mau", "Nữ"));
        studentList.add(new Student("Nguyễn K", 24, "Cà Mau", "Nam"));

        //Khởi tạo adapter
        //ListviewAdapter là cái mình vừa custom đó nhá
        listviewAdapter = new ListviewAdapter(this, studentList);
        //set adapter cho listview
        listView.setAdapter(listviewAdapter);

        //Dang ki context menu cho ListView
        registerForContextMenu(listView);
        listView.setLongClickable(true);
        //menu edit xảy ra khi long click thì bắt ngay long click
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //View view, int position
                //quan tâm 2 chú trên thôi, view là cái view holder đấy, position là vị trí nhá
                mViewHolder = view;
                mPosition=position;
                //Lấy view rồi nhá
                return false;
            }
        });

//================================================ADD=======================
//sự kiên thêm vào list
     mAdd.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             //Cái tội chưa thêm mà ghi đã thêm, e bá đạo :D.
             if(buttonFormat == ButtonFormat.ADD) {
                 int age = Integer.parseInt(mEditTextAge.getText() + "");
                 String name = mEditTextName.getText() + "";
                 String country = mEditTextCountry.getText() + "";
                 String gender = mEditTextGender.getText() + "";
                 student = new Student();
                 student.setCountry(country);
                 student.setName(name);
                 student.setGender(gender);
                 student.setAge(age);
                 studentList.add(student);
                 listviewAdapter.notifyDataSetChanged();//cập nhật lại danh sách
                 Toast.makeText(getBaseContext(), "Đã thêm: " + mEditTextName.getText() + "", Toast.LENGTH_LONG).show();
             }
             else if(buttonFormat == ButtonFormat.EDIT)
             {
                 studentList.get(mPosition).setName(mEditTextName.getText().toString());
                 studentList.get(mPosition).setAge(Integer.parseInt(mEditTextAge.getText().toString()));
                 studentList.get(mPosition).setCountry(mEditTextCountry.getText().toString());
                 studentList.get(mPosition).setGender(mEditTextGender.getText().toString());
                 listviewAdapter.notifyDataSetChanged();
                 mAdd.setText(R.string.string_button_add);
                 buttonFormat = ButtonFormat.ADD;
                 Toast.makeText(getBaseContext(), "Đã xử lý sửa", Toast.LENGTH_LONG).show();
             }

         }
     });
        //Sự kiện này là khi click lên 1 item
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //Quay lại sự kiến nhấn trên 1 item
//                //Khi nhấn trên 1 Item thì e quan tâm cho a 2 đối số nó cho e
//                //View view, int position
//                //view này chính là cái layout e custom(listview_item_layout) lúc nãy,
//                //E dùng nó khi e cần getid của cái gì trên đó, còn ko thì bỏ qua
//                //position chính là vị trí phần tử mà đang hiển thị trên item listview e nhấn, trừng với vị trí trong List e đưa vào
//           //Giờ a xử lý nhá
//                mTextTitle.setText("Tên: "+studentList.get(position).getName()+", Tuổi: "+
//                        studentList.get(position).getAge());
//                //Vậy là xong, e run thử nào. dc roi nha a, a xem hinh, ok. Giờ bawtss trên view holder nhá
//            }
//        });
        //Sự kiện này gọi khi e nhấn giữ 1 item
  //  listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
   //        @Override
     //      public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
       //
         //      return true;
          //}
        //});

    }
    //a tạo 1 hàm để thay đổi text cho nó
    public void setmTextTitle(String s){
        mTextTitle.setText(s);
    }


    //nạp context menu vao app
//    int CONTEXT_MENU_VIEW =1;
//    int CONTEXT_MENU_EDIT = 2;
//    int CONTEXT_MENU_ARCHIVE = 3;
    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(contextMenu,v,menuInfo);
        getMenuInflater().inflate(R.menu.mymenu,contextMenu);
//        contextMenu.setHeaderTitle("My Context Menu");
//        contextMenu.add(Menu.NONE, CONTEXT_MENU_VIEW, Menu.NONE, "Add");
//        contextMenu.add(Menu.NONE, CONTEXT_MENU_EDIT, Menu.NONE, "Edit");
//        contextMenu.add(Menu.NONE, CONTEXT_MENU_ARCHIVE, Menu.NONE, "Delete");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mDelete:
                new AlertDialog.Builder(this)
                        .setTitle("Thông báo")
                        .setMessage("Bạn có muốn xóa?")
                        .setPositiveButton(R.string.string_delete_ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                                ///android.R.string.yes
                                //yes là xóa :D
                                studentList.remove(mPosition);
                                listviewAdapter.notifyDataSetChanged();
                                Toast.makeText(getBaseContext(),"Đã xóa",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton(R.string.string_delete_not, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setNeutralButton(R.string.app_name, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //function this

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

                //Biết hàm xóa e quăng chỗ nào chưa?
                break;
            case R.id.mEdit:
                //Toast.makeText(getBaseContext(),"click Edit",Toast.LENGTH_LONG).show();
                if(mViewHolder!=null)
                {
                    mEditTextName.setText(studentList.get(mPosition).getName());//dung position thay view
                   // mEditTextName.setText(((TextView)mViewHolder.findViewById(R.id.textViewName)).getText());
                    mEditTextName.setText(((TextView)mViewHolder.findViewById(R.id.textViewName)).getText());
                    mEditTextAge.setText(((TextView)mViewHolder.findViewById(R.id.textViewAge)).getText());
                    mEditTextCountry.setText(((TextView)mViewHolder.findViewById(R.id.textViewCountry)).getText());
                    mEditTextGender.setText(((TextView)mViewHolder.findViewById(R.id.textViewGender)).getText());
                    mAdd.setText(R.string.string_button_save);
                    buttonFormat = ButtonFormat.EDIT;
                }
                break;
        }
        return super.onContextItemSelected(item);
    }

}
