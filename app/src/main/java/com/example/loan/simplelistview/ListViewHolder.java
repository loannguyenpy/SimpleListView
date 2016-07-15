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
    // EditText

    private Context mContext;

    //Phương thức khởi tạo cho nó 1 cái view để get id, view này lát nữa lấy bên adapter
    //Cái view e truyền vào để get id chính là cái view e custom đó. Nên bắt sự kiện click item là bắt nó đấy
    public ListViewHolder(View view, Context context) {
        mList = (TextView) view.findViewById(R.id.textList);
        mName = (TextView) view.findViewById(R.id.textViewName);
        mAge = (TextView) view.findViewById(R.id.textViewAge);
        mCon = (TextView) view.findViewById(R.id.textViewCountry);
        mGen = (TextView) view.findViewById(R.id.textViewGender);
        //get id o view edit

        mContext = context;


        ///==============

        //E bắt ở đây luôn, ko cần đi dài dòng
        //E chú ý, textView mà hiển thị a nói kía nó nằm ở MAin,mà e dang ở 1 class khác, e hiểu ko?, cái a vừa khoanh á. hiu a
        //Vì vậy để dùng được nó, e phải có thằng đại diện cho nó, đĩ nhiên e phải truyền nó vào đây,
        //Trong android, context là đại diện của activity nha////cho e xiu nha a// ok e...xong
        //E hiểu đoạm trên chưa?roi a
        //Mà context thì get ở activity,
        //E thấy trong adapter mình có truyền context đúng ko?
        //za
        //Vậy giờ lấy nó qua đây thì truyền nó vào  thôi
        //Vậy là có thằng đại diện cho activity
        //Mà textview kia trên actity là private nên mình đâu đụng chạm nó được
        //Vì vậy phải có hàm làm việc với nó nhá
        //Giờ thỏa mái xử lý nà

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tên nằm ở dâu e biêt ko?. k a
                //Set xong thì tên nằm ở textviewName
                //ok ko e ok
                //tiếp
                //Vì sao a gọi vậy?
                //vi mcontext dai dien cho main
                //Ví dụ mContext a truyền vào từ DemoActivity thì nó đại đại diện cho ai? cho DemoActiviry, đúng rồi. E nhớ nhá
                //Truyền từ đâu thì nó đại diện cho thằng đó.
                //ôi, a truyền basecontext
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
                //ok a
                //Rồi, chăm học thì sẽ nhanh hiểu thôi. Phần này còn chưa quá khó hiểu đâu
                //hihi. ok a
                //Đi ngủ nà. :D
                //anh ngu ngon nha
                //E cũng vậy nhá, ngủ ngon, mai trả bài cho a :D, a out á
            }
        });


        //========================SỰ KIỆN ADD===============================
        mGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "thông báo gì?", Toast.LENGTH_LONG).show();
            }
        });
    }

    //Lấy xong thì cần set dữ liệu cho nó nha, cần hiển thị cái nào thì cho đối tượng đó vào
    //E gắm pin

    public void setData(Student student) {
        //Giờ set dũ liệu nha
        mName.setText(student.getName());
        mAge.setText(student.getAge() + "");
        mCon.setText(student.getCountry());
        mGen.setText(student.getGender());
    }
    //Xong view holder, quá dễ nhỡ :D
    //Giờ thì dĩ nhiên tới Adapter
}
