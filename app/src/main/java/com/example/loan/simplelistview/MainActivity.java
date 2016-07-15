package com.example.loan.simplelistview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private TextView mTextTitle;
    ListviewAdapter listviewAdapter;
    Student student=null;
    EditText mEditTextName;
    EditText mEditTextAge;
    EditText mEditTextCountry;
    EditText mEditTextGender;
    Button mAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listview);

        mTextTitle = (TextView) findViewById(R.id.textTitle);

        mEditTextName = (EditText) findViewById(R.id.edutTextName);
        mEditTextAge = (EditText) findViewById(R.id.edutTextAge);
        mEditTextCountry = (EditText) findViewById(R.id.edutTextCountry);
        mEditTextGender = (EditText) findViewById(R.id.edutTextGender);
        mAdd = (Button) findViewById(R.id.buttonAdd);


        final List<Student> studentList = new ArrayList<>();
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
//================================================ADD=======================

//sự kiên thêm vào list
     mAdd.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Toast.makeText(getBaseContext(),"Đã thêm: "+mEditTextName.getText()+"",Toast.LENGTH_LONG).show();
             int age=Integer.parseInt(mEditTextAge.getText()+"");
             String name=mEditTextName.getText()+"";
             String country=mEditTextCountry.getText()+"";
             String gender=mEditTextGender.getText()+"";
             student=new Student();
             student.setCountry(country);
             student.setName(name);
             student.setGender(gender);
             student.setAge(age);
             studentList.add(student);
             listviewAdapter.notifyDataSetChanged();//cập nhật lại danh sách

         }
     });

        //Sự kiện click lên 1 item mà listview có hổ trợ sẳn
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
        //Bỏ trên này đi, sang view holder bắt

        //A giới thiệu luôn vài sự kiện có thể e dùng sau này
        //Sự kiện này gọi khi e nhấn giữ 1 item
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                return false;
//            }
//        });
        //Chạy thử xem kết quả nào. chay tren dt luon cho nhanh nha
        //ok e
        //Xong
       //Giờ a muốn hiển thị hết danh sách này lên listview, theo e thì được ko? Với mỗi item là giao diện như lúc nãy?
        //duoc a, nhung e k biet lam ..
        //A sẽ bày từ dễ đến khó dần
        //Ở đây a bày theo cách a hay làm. Android có rất nhiều cách code, nhưng a lười nên luôn làm cái đơn giản và ngắn gọn nhất
        //Ráng đọc hiểu nha e.ok
        //Bình thường thì chỉ cần 1 adapter thì hiển thị được, nhưng như vậy sẽ làm code rối tung lên,
        //Nên a sẽ chỉ e cách dùng view holder, đây là cách hay và là a khuyên e dùng (hồi a học thì cô ko nói
        //cái này, nhưng mà đúng chớ ko sai nha.
        //1.Tạo 1 cái view holder, đây là chỗ e xử lý cái view á
//Tạo cho a 1 đối tượng chứa hết những thông tin như lúc nãy nào.
        //cai Country[] t ko dc ha a
        //Tạo 1 đối tượng có đủ 4 thông tin như nãy trên layout á e. Bỏ cái nãy e làm nha, nó đơn giản
        //ok a. ak ma tạo o class khac chu a
        //Dĩ nhiên rồi
        //E tạo 1 đối tượng riêng biệt

        //String [] t=new String[]{"Ha Noi", "Hai Phong","HCM","Binh Duong","Khanh Hoa","Quang Binh","Quang Nam","Phu Yen","Binh Dinh","Ca Mau"};
        // ArrayAdapter <String> arrayAdapter =new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1,t);

        //Kết quả sao e. de em chup hinh gui anh ha
        //ok e

    }
    //a tạo 1 hàm để thay đổi text cho nó
    public void setmTextTitle(String s){
        mTextTitle.setText(s);
    }
}
