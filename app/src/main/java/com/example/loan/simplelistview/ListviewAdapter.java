package com.example.loan.simplelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by LOAN on 7/12/2016.
 */
//E nhớ lớp cha nó nha, a thường dùng thằng này, ngoài ra nó còn arrayAdapter nhưng mà a ít dùng
    //E thấy thằng nào tiện là dùng, còn theo a thì dùng cái này nha
public class ListviewAdapter extends BaseAdapter {
    //Ở đây nó báo lỗi thì e phải over lại tất cả các phương thức trừu tượng của nó, e nhấn alt+insert là ra 1 list các hàm
    //a nhầm :D
 //Lôi hết mấy cha nội nay vào là được

    //Hàm này e cần cái list hiển thị và 1 cái context nhá
    //E nhớ 2 biến này nha.

    Context mContext;
    List<Student> studentList;
    public ListviewAdapter(Context context, List<Student> studentList) {
        super();
        mContext = context;
        this.studentList = studentList;
        //Xong hàm này nhá
    }

    @Override
    public int getCount() {
        //Hàm này mà quên là sai nha.
        return studentList.size();
        //Hết
    }

    @Override
    public Object getItem(int position) {
        //Hàm này nữa
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        //hàm này ko quan trọng
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Cha này là quan trọng nhất nhá. :D
        //Quên cha này là có chuyện á. :d
        //Tạo 1 cái view
        View view;
        //Dợi a tí. mở cửa bạn a
        //Tiếp nha
        //E có đó ko? ok a
        //Bây giờ gọi cái holder lúc nãy ra nhá
        final ListViewHolder listViewHolder;
        //Kiểm tra xem cái view hiển thị nó có rỗng ko
        if(convertView==null){
            //Nếu nó rỗng nghĩa là nó chưa nhận view của mình
            //thì gán view cho nó
            //Nhớ dòng này kỹ nhá., có cái layout kìa, đó là e chỉ ra là listview hiển thị bằng layout nào
            //e hiểu ko?. vay tu parent, voi false a
            //Cái parent là nhận từ hàm nó kìa e, false là view đó hiển thị và fill bằng trong listview
            //E chỉ cần quan tâm cái chỗ layout, gán cho đúng layout, còn lại hàm này e copy y chang nhá
            //:D. anh. cai cho listview_item_layout ak, bai nao cung giong nhau hay bai khac ten cua no cung khac a
            //E thích đặt gì đặt chớ, ví dụ item_studen_listview cũng đc
            //vay CHINH LA CAI LAYOUT hoi nay e tao ak ha a
            //èo, nãy giờ ko hiểu hả e, custom listview tức là e gán lại layout của của item trên listview theo ý e á
            //Bài này a muốn nó hiển thị mỗi item là 1 layout như nãy e tạo
            //e hiểu ko
            //E biết cái layout lấy ở đâu chưa>?. roi a. tai vi no viwt hoa chu L nen e thac mac
            //Chữ thường mà ta :D. hihi
            //Giờ gán apdapter cho listview nhá.
            view = LayoutInflater.from(mContext).inflate(R.layout.listview_item_layout, parent, false);
            //Xong là gán view cho cái Viewholder để nó get id nhá
            listViewHolder = new ListViewHolder(view, mContext);
            //Set tag cho nó để lần sau nó ko rổng thì dùng lại
            view.setTag(listViewHolder);
        }
        else{
            //Nếu cái view trên màn hình ko rỗng thì lấy view từ tag
            view = convertView;
            listViewHolder = (ListViewHolder) view.getTag();
        }
        //Xong vụ view, đến vụ dữ liệu

        if(listViewHolder!=null){
            listViewHolder.setData(studentList.get(position));
        }
        return view;
    }
    //Xong hết
    //Hiểu hồng :D. chac em hoc thuoc qua :p
    //Cái Adapter thì e ko cần code đâu. LÀm y chang a thì được, nhưng nhớ đổi đối tượng, Còn riêng cái Holder thì bắc buộc
    //e phải biết code nhá, vì mỗi bài mỗi view holder khác nhau. A cố tình tách view holder là để dễ dàng cho e dùng lại code :D
    //moi bai thi viewholder khac nhau nhu the nao a
    //Bài này có 4 textview thì e get id và set dữ liệu cho 4 cái. Lỡ bài khác nó 2 textview, 2 button thì e lại getid khác
    //af hihi
    //Ok ko
    //ok
    //Còn cái adapter, nhớ được thì tốt, ko nhớ thì copy dán rồi sửa đối tượng là xong :D. :v vay la xong het r ha a
    //Uh e, xong rồi đấy
}
