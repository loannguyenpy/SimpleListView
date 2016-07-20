package com.example.loan.simplelistview;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by LOAN on 7/12/2016.
 */
public class ListViewHolder {
    //Gọi hết mấy thằng e cần hiển thị vào đây nha
    TextView mName;
    TextView mAge;
    TextView mCon;
    TextView mGen;
    TextView mList;
    private Context mContext;

    //Phương thức khởi tạo cho nó 1 cái view để get id, view này lát nữa lấy bên adapter
    //dc roi a
    //Vậy lỗi là từ chỗ các hàm onclick
    //:D
    //
    //Cái view e truyền vào để get id chính là cái view e custom đó. Nên bắt sự kiện click item là bắt nó đấy
    public ListViewHolder(View view, Context context) {
        mList = (TextView) view.findViewById(R.id.textList);
        mName = (TextView) view.findViewById(R.id.textViewName);
        mAge = (TextView) view.findViewById(R.id.textViewAge);
        mCon = (TextView) view.findViewById(R.id.textViewCountry);
        mGen = (TextView) view.findViewById(R.id.textViewGender);
        //get id o view edit

        mContext = context;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vi mcontext dai dien cho main
                //Ví dụ mContext a truyền vào từ DemoActivity thì nó đại đại diện cho ai? cho DemoActiviry
                //Truyền từ đâu thì nó đại diện cho thằng đó.
                ((MainActivity) mContext).setmTextTitle("Tên: " + mName.getText() + ", Tuổi: " + mAge.getText());
                //Xong e run xem
            }
        });
        //Get tiep id nó vào ngay khởi tạo này luôn
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.line_name);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) mContext).setmTextTitle("Đã click đúng line name!: " + mName.getText());
            }
        });
        //Còn muốn bắt sự kiện khi cick cho textage thì gọi nó ra set, textage a đã get id ở trên rồi nha
        mAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) mContext).setmTextTitle("Đã click đúng text tuổi!: " + mAge.getText());
                //Ví dụ a muốn hiện tosa ngáy đây thì a gọi như sau
                Toast.makeText(mContext, "thông báo gì?", Toast.LENGTH_LONG).show();
                //hổm rày là getBaseactivity, nhưng ở đây context đại diện activity nên cho nó vào là đc nha e

            }
        });

view.setLongClickable(true); // hàng này là 2, ok ko e. ok a
        //Giờ e thử xử lý edit a xem cái
        // xu li khi click vao edit ha a
        //đúng rồi
//        view.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                return false;
//            }
//        });
        //========================SỰ KIỆN ADD===============================
        mGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "thông báo gì?", Toast.LENGTH_LONG).show();
            }
        });
        //máy e là android 4. mấy? 4.4.2
        //ok để a xem lại, đã, vụ này chưa gặp. hay a chay may ao thu xem
        //để a xem thử nó có vấn đề gì với bản hệ điều hành cuae e ko đã

    }

    public void setData(Student student) {
        //Giờ set dũ liệu nha
        mName.setText(student.getName());
        mAge.setText(student.getAge() + "");
        mCon.setText(student.getCountry());
        mGen.setText(student.getGender());
    }
}
