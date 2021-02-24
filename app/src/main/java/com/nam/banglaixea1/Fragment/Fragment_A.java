package com.nam.banglaixea1.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nam.banglaixea1.Adapter.FigureBAdapter;

import com.nam.banglaixea1.Module.Figure;
import com.nam.banglaixea1.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_A extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private List<Figure> list;
    private List<Figure> list_new=new ArrayList<>();
    private FigureBAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_a, container, false);
        recyclerView = view.findViewById(R.id.recycler_a);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter=new FigureBAdapter(list,getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListData();

     }
    private void ListData(){
        list = new ArrayList<>();
        list.add(new Figure(R.drawable.a1, "Biển số 101 \"Đường cấm\"", "báo đường cấm tất cả các loại phương tiện (cơ giới và thô sơ) đi lại cả hai hướng, trừ các xe được ưu tiên theo quy định"));
        list.add(new Figure(R.drawable.a2, "Biển số 102 \"Cấm đi ngược chiều\"", "báo đường cấm tất cả các loại xe (cơ giới và thô sơ) đi vào theo chiều đặt biển, trừ các xe được ưu tiên theo quy định"));
        list.add(new Figure(R.drawable.a3, "Biển số 103a \"Cấm ô tô\"", "báo đường cấm tất cả các loại xe cơ giới kể cả môtô 3 bánh có thùng đi qua, trừ môtô hai bánh, xe gắn máy và các xe được ưu tiên theo quy định"));
        list.add(new Figure(R.drawable.a4, "Biển số 103b \"Cấm ô tô rẽ phải\"", " báo đường cấm tất cả các loại xe cơ giới kể cả môtô 3 bánh có thùng rẽ phải, trừ môtô hai bánh, xe gắn máy và các xe được ưu tiên theo quy định"));
        list.add(new Figure(R.drawable.a5, "Biển số 103c \"Cấm ô tô rẽ trái\"", "báo đường cấm tất cả các loại xe cơ giới kể cả môtô 3 bánh có thùng rẽ trái, trừ môtô hai bánh, xe gắn máy và các xe được ưu tiên theo quy định"));
        list.add(new Figure(R.drawable.a6, "Biển số 104 \"Cấm mô tô\"", "báo đường cấm tất cả các loại môtô đi qua, trừ các xe môtô được ưu tiên theo quy định"));
        list.add(new Figure(R.drawable.a7, "Biển số 105 \"Cấm ô tô và mô tô\"", "báo đường cấm tất cả các loại xe cơ giới và môtô đi qua trừ xe gắn máy và các xe được ưu tiên theo quy định"));
 //       list.add(new Figure(R.drawable.a8, "Biển số 106a \"Cấm ô tô tải\"", "báo đường cấm tất cả các loại ôtô chở hàng có trọng tải từ 1,5 tấn trở lên trừ các xe được ưu tiên theo quy định. Biển có hiệu lực cấm đối với cả máy kéo và các xe máy chuyên dùng."));
 //       list.add(new Figure(R.drawable.a9, "Biển số 106b \"Cấm ô tô tải\"", "có tổng trọng lượng (trọng lượng xe cộng hàng) vượt quá con số đã quy định trên biển. Biển có hiệu lực cấm đối với cả máy kéo và các xe máy chuyên dùng đi vào đoạn đường đặt biển. "));
        list.add(new Figure(R.drawable.a10, "Biển số 106c \"Cấm xe chở hàng nguy hiểm”", "báo đường cấm các xe chở hàng nguy hiểm"));
        list.add(new Figure(R.drawable.a11, "Biển số 107 \"Cấm ô tô  khách và ô tô  tải\"", "báo đường cấm ôtô chở khách và các loại ôtô tải kể cả các loại máy kéo và xe máy thi công chuyên dùng đi qua trừ các xe được ưu tiên theo quy định"));
        list.add(new Figure(R.drawable.a29, "Biển số 108 \"Cấm  ô tô, máy kéo kéo moóc hoặc sơ mi rơ moóc\"", "báo đường cấm tất cả các loại xe cơ giới kéo theo rơ-moóc kể cả môtô, máy kéo, ôtô khách kéo theo rơ-moóc đi qua, trừ loại ôtô sơ-mi rơ-moóc và các xe được ưu tiên (có kéo theo rơ-moóc) theo luật lệ nhà nước quy định"));
        list.add(new Figure(R.drawable.a12, "Biển số 109 \"Cấm máy kéo\"", "báo đường cấm tất cả các loại máy kéo, kể cả máy kéo bánh hơi và bánh xích đi qua"));
        list.add(new Figure(R.drawable.a13, "Biển số 110a \"Cấm đi xe đạp\"", "báo đường cấm xe đạp đi qua. Biển không có giá trị cấm những người dắt xe đạp"));
        list.add(new Figure(R.drawable.a14, "Biển số 110b \"Cấm xe đạp thồ\"", "báo đường cấm xe đạp thồ đi qua. Biển không có giá trị cấm những người dắt xe đạp. Biển này không cấm người dắt loại xe này"));
        list.add(new Figure(R.drawable.a15, "Biển số 111a \"Cấm xe gắn máy\"", "báo đường cấm xe gắn máy đi qua. Biển không có giá trị đối với xe đạp"));
        list.add(new Figure(R.drawable.a16, "Biển số 111b \"Cấm xe ba bánh loại có động cơ\"", "báo đường cấm xe ba bánh loại có động cơ như xe lam, xích lô máy v.v..."));
        list.add(new Figure(R.drawable.a17, "Biển số 111c \"Cấm xe ba bánh loại có động cơ\"", "báo đường cấm xe ba bánh loại có động cơ như xe lôi máy v.v..."));
        list.add(new Figure(R.drawable.a18, "Biển số 111d \"Cấm xe ba bánh loại không có động cơ\"", "báo đường cấm xe ba bánh loại không có động cơ như xích lô, xe lôi đạp v.v..."));
        list.add(new Figure(R.drawable.a19, "Biển số 112 \"Cấm người đi bộ\"", "báo đường cấm người đi bộ qua lại"));
        list.add(new Figure(R.drawable.a20, "Biển số 113 \"Cấm xe người kéo, đẩy\"", "báo đường cấm xe thô sơ, chuyển động do người kéo, đẩy đi qua. Biển không có giá trị cấm những xe nôi của trẻ em và phương tiện chuyên dùng để đi lại của những người tàn tật."));
        list.add(new Figure(R.drawable.a21, "Biển số 114 \"Cấm xe súc vật kéo\"", "báo đường cấm súc vật vận tải hàng hóa hoặc hành khách dù kéo xe hay chở trên lưng đi qua"));
//        list.add(new Figure(R.drawable.a22, "Biển số 115 \"Hạn chế trọng lượng xe\"", "báo đường cấm các loại xe (cơ giới và thô sơ) kể cả các xe được ưu tiên theo quy định, có trọng lượng toàn bộ (cả xe và hàng) vượt quá trị số ghi  trên biển đi qua"));
//        list.add(new Figure(R.drawable.a23, "Biển số 116 \"Hạn chế trọng lượng trên trục xe\"", "báo đường cấm các loại xe (cơ giới và thô sơ) kể cả các xe được ưu tiên theo quy định, có trọng lượng toàn bộ (cả xe và hàng) phân bổ trên một trục bất kỳ của xe vượt quá trị số ghi trên biển đi qua"));
//        list.add(new Figure(R.drawable.a24, "Biển số 117 \"Hạn chế chiều cao\"", "báo hạn chế chiều cao của xe, cấm các xe (cơ giới và thô sơ) có chiều cao vượt quá trị số ghi trên biển không được đi qua, kể cả các xe được ưu tiên theo quy định (chiều cao tính từ mặt đường, mặt cầu đến điểm cao nhất của xe hoặc hàng)"));
//        list.add(new Figure(R.drawable.a25, "Biển số 118 \"Hạn chế chiều ngang\"", "báo hạn chế chiều ngang của xe, cấm các xe (cơ giới và thô sơ) kể cả các xe được ưu tiên theo quy định có chiều ngang (kể cả xe và hàng hóa) vượt quá trị số ghi trên biển không được đi qua. "));
//        list.add(new Figure(R.drawable.a26, "Biển số 119 \"Hạn chế chiều dài ôtô\"", "báo đường cấm các loại xe (cơ giới và thô sơ) kể cả các xe được ưu tiên theo quy định, có độ dài toàn bộ kể cả xe và hàng lớn hơn trị số ghi trên biển đi qua"));
//        list.add(new Figure(R.drawable.a27, "Biển số 120 \"Hạn chế chiều dài ôtô, máy kéo kéo moóc hoặc sơ mi rơ moóc\"", "báo đường cấm các loại xe (cơ giới và thô sơ) kéo theo moóc kể cả ôtô sơ-mi rơ-moóc và các loại xe được ưu tiên kéo moóc theo luật lệ nhà nước quy định, có độ dài toàn bộ kể cả xe, moóc và hàng lớn hơn trị số ghi trên biển đi qua"));
//        list.add(new Figure(R.drawable.a30, "Biển số 121 \"Cự ly tối thiểu giữa hai xe\"", "báo xe ôtô phải đi cách nhau một khoảng tối thiểu tính bằng mét"));
        list.add(new Figure(R.drawable.a31, "Biển số 122 \"Dừng lại\"", "buộc các loại xe cơ giới và thô sơ kể cả xe được ưu tiên theo quy định dừng lại trước biển hoặc trước vạch ngang đường và chỉ được phép đi khi thấy các tín hiệu (do người điều khiển giao thông hoặc đèn cờ) cho phép đi. Trong trường hợp trên đường không đặt tín hiệu đèn cờ, không có người  điều khiển giao thông hoặc các tín hiệu đèn không bật sáng thì người lái xe chỉ được phép đi khi trên đường không còn nguy cơ mất an toàn giao thông"));
        list.add(new Figure(R.drawable.a32, "Biển số 123a \"Cấm rẽ trái\"", "cấm các loại xe (cơ giới và thô sơ) rẽ sang phía trái ở những vị trí đường giao nhau trừ các xe được ưu tiên theo quy định. Biển này cũng cấm xe quay đầu"));
        list.add(new Figure(R.drawable.a33, "Biển số 123b \"Cấm rẽ phải\"", "cấm các loại xe (cơ giới và thô sơ) rẽ sang phía phải ở những vị trí đường giao nhau trừ các xe được ưu tiên theo quy định."));
        list.add(new Figure(R.drawable.a34, "Biển số 124a \"Cấm quay xe\"", "báo cấm các loại xe cơ giới và thô sơ quay đầu (theo kiểu chữ U) trừ các xe được ưu tiên theo quy định. Biển này không cấm rẽ trái."));
        list.add(new Figure(R.drawable.a35, "Biển số 124b \"Cấm ô tô quay đầu xe\"", "báo cấm xe ôtô và mô tô 3 bánh quay đầu (theo kiểu chữ U), trừ các xe được ưu tiên theo quy định. Biển này không cấm rẽ trái."));
        list.add(new Figure(R.drawable.a36, "Biển số 125 \"Cấm vượt\"", "báo cấm các loại xe cơ giới vượt nhau kể cả xe được ưu tiên theo quy định"));
        list.add(new Figure(R.drawable.a37, "Biển số 126 \"Cấm ôtô  tải vượt\"", "báo cấm các loại ôtô tải vượt xe cơ giới khác. Biển có hiệu lực cấm tất cả các loại ôtô tải có trọng lượng lớn nhất cho phép (bao gồm trọng lượng xe và hàng) trên 3,5Tấn kể cả các xe được ưu tiên theo quy định vượt xe cơ giới khác."));
        list.add(new Figure(R.drawable.a38, "Biển số 127 \"Tốc độ tối đa cho phép\"", "báo tốc độ tối đa cho phép các xe cơ giới chạy, trừ các xe được ưu tiên theo quy định"));
        list.add(new Figure(R.drawable.a39, "Biển số 128 \"Cấm sử dụng còi\"", "báo cấm các loại xe cơ giới sử dụng còi"));
        list.add(new Figure(R.drawable.a40, "Biển số 129 \"Kiểm tra\"", "báo nơi đặt trạm kiểm tra; các loại phương tiện vận tải qua đó phải dừng lại để làm thủ tục kiểm tra, kiểm soát theo quy định. "));
        list.add(new Figure(R.drawable.a41, "Biển số 130 \"Cấm dừng xe và đỗ xe\"", "báo nơi cấm dừng xe và đỗ xe. Biển có hiệu lực cấm các loại xe cơ giới dừng và đỗ ở phía đường có đặt biển trừ các xe được ưu tiên theo quy định"));
        list.add(new Figure(R.drawable.a42, "Biển số 131a \"Cấm đỗ xe\"", "báo nơi cấm đỗ xe trừ các xe được ưu tiên theo quy định"));
        list.add(new Figure(R.drawable.a43, "Biển số 131b \"Cấm đỗ xe\"", "báo nơi cấm đỗ xe cơ giới vào những ngày lẻ"));
        list.add(new Figure(R.drawable.a44, " Biển số 131c \"Cấm đỗ xe\"", "báo nơi cấm đỗ xe cơ giới vào những ngày chẵn "));
        list.add(new Figure(R.drawable.a45, "Biển số 132 \"Nhường đường cho xe cơ giới đi ngược chiều qua đường hẹp\"", "báo các loại xe (cơ giới và thô sơ) kể cả các xe được ưu tiên theo quy định phải nhường đường cho các loại xe cơ giới đang đi theo hướng ngược lại qua các đoạn đường hẹp hoặc cầu hẹp"));
        list.add(new Figure(R.drawable.a46, "Biển số 133 \"Hết cấm vượt\"", "báo hết đoạn đường cấm vượt"));
        list.add(new Figure(R.drawable.a47, "Biển số 134 \"Hết hạn chế tốc độ tối đa\"", "báo hết đoạn đường hạn chế tốc độ tối đa"));
        list.add(new Figure(R.drawable.a48, "Biển số 135 \"Hết tất cả các lệnh cấm\"", "báo hết đoạn đường mà nhiều biển báo cấm cùng hết hiệu lực"));
        list.add(new Figure(R.drawable.a49, "Biển số 136 \"Cấm đi thẳng\"", "cấm tất cả các loại xe đi thẳng trên đoạn đường phía trước"));
        list.add(new Figure(R.drawable.a50, "Biển số 137 \"Cấm rẽ trái và rẽ phải\"", "cấm tất cả các lại xe rẽ trái hay rẽ phải trên các ngả đường phía trước"));
        list.add(new Figure(R.drawable.a51,"Biển số 138 \"Cấm đi thẳng và rẽ trái\"","biểu thị đường qua nút giao cấm tất cả các loại xe đi thẳng và rẽ trái"));
        list.add(new Figure(R.drawable.a52,"Biển số 139 \"Cấm đi thẳng và rẽ phải\"","biểu thị đường qua nút giao cấm tất cả các loại xe đi thẳng và rẽ phải"));
        list.add(new Figure(R.drawable.a53,"Biển số 140 \"Cấm xe công nông\"","để báo đường cấm công nông"));
    }

    @Override
    public void onPause() {
        super.onPause();
        list.clear();
    }
}
