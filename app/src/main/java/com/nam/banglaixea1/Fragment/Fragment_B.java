package com.nam.banglaixea1.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nam.banglaixea1.Adapter.FigureBAdapter;
import com.nam.banglaixea1.Module.Figure;
import com.nam.banglaixea1.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_B extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private List<Figure> list = new ArrayList<>();
    private FigureBAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_a, container, false);
        recyclerView = view.findViewById(R.id.recycler_a);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new FigureBAdapter(list, getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.clear();
        list.add(new Figure(R.drawable.b1, "Biển số 201a \"Chỗ ngoặt nguy hiểm vòng bên trái\"", "báo trước sắp đến một chỗ ngoặt nguy hiểm phía bên trái"));
        list.add(new Figure(R.drawable.b2, "Biển số 201b \"chỗ ngoặt nguy hiểm vòng bên phải\"", "báo trước sắp đến một chỗ ngoặt nguy hiểm phía bên phải"));
        list.add(new Figure(R.drawable.b3, "Biển số 203a \"Đường bị hẹp cả hai bên\"", "báo trước sắp đến một đoạn đường bị hẹp đột ngột cả hai bên"));
        list.add(new Figure(R.drawable.b4, "Biển số 203b \"Đường bị hẹp về phía trái\"", "báo trước sắp đến một đoạn đường bị hẹp đột ngột phía bên trái"));
        list.add(new Figure(R.drawable.b5, "Biển số 203c \"Đường bị hẹp về phía phải\"", "báo trước sắp đến một đoạn đường bị hẹp đột ngột phía bên phải"));
        list.add(new Figure(R.drawable.b6, "Biển số 204 \"Đường hai chiều\"", "báo trước sắp đến đoạn đường do sửa chữa hoặc có trở ngại ở một phía đường mà phải tổ chức đi lại cho phương tiện cả hai chiều trên phía đường còn lại hoặc để báo trước đoạn đường đôi tạm thời hoặc đoạn đường có chiều xe đi và về đi chung"));
        list.add(new Figure(R.drawable.b7, "Biển số 205a \"Đường giao nhau cùng cấp\"", "báo trước sắp đến nơi giao nhau cùng mức của các tuyến đường cùng cấp (không có đường nào ưu tiên)  trên cùng một mặt bằng"));
        list.add(new Figure(R.drawable.b8, "Biển số 206 \"Giao nhau chạy theo vòng xuyến\"", "báo trước nơi giao nhau có bố trí đảo an toàn ở giữa nút giao, các loại xe qua nút giao phải đi vòng xuyến quanh đảo an toàn theo chiều mũi tên"));
        list.add(new Figure(R.drawable.b9, "Biển số 207a \"Giao nhau với đường không ưu tiên\"", "báo trước sắp đến nơi giao nhau với đường không ưu tiên"));
        list.add(new Figure(R.drawable.b10, "Biển số 208 \"Giao nhau với đường ưu tiên\"", "để báo trước sắp đến nơi giao nhau với đường ưu tiên"));
        list.add(new Figure(R.drawable.b11, "Biển số 209 \"Giao nhau có tín hiệu đèn\"", "báo trước nơi giao nhau có điều khiển giao thông bằng tín hiệu đèn trong trường hợp người lái xe khó quan sát để kịp thời xử lý"));
        list.add(new Figure(R.drawable.b12, "Biển số 210 \" Giao nhau với đường sắt có rào chắn\"", "báo trước sắp đến chỗ giao nhau giữa đường bộ và đường sắt có rào chắn kín hay rào chắn nửa kín và có nhân viên ngành đường sắt điều khiển giao thông"));
        list.add(new Figure(R.drawable.b13, "Biển số 211a \"Giao nhau với đường sắt không có rào chắn\"", "báo trước sắp đến chỗ giao nhau giữa đường bộ và đường sắt không có rào chắn, không có người điều khiển giao thông"));
        list.add(new Figure(R.drawable.b28, "Biển số 211b \"Giao nhau với đường tàu điện\"", "chỉ nơi đường bộ giao nhau cùng mức với đường tàu điện"));
        list.add(new Figure(R.drawable.b14,"Biển số 221a \"Đường có ổ gà, lồi lõm\"","đặt trong trường hợp đường đang tốt, xe chạy nhanh, chuyển sang những đoạn lồi lõm, gập ghềnh, ổ gà, lượn sóng"));
        list.add(new Figure(R.drawable.b15, "Biển số 221b \"Đường có sóng mấp mô nhân tạo\"", "để hạn chế tốc độ xe chạy (biển được cắm kèm theo biển số 227 \"Hạn chế tốc độ tối đa\"), bắt buộc lái xe phải chạy với tốc độ chậm trước khi qua những điểm cần kiểm soát, kiểm tra hoặc giảm tốc độ trước khi vào đoạn đường hạn chế tốc độ tối đa"));
        list.add(new Figure(R.drawable.b16, "Biển số 224 \"Đường người đi bộ cắt ngang\"", "báo trước sắp tới phần đường dành cho người đi bộ sang qua đường. Gặp biển này các xe phải giảm tốc độ, nhường ưu tiên cho người đi bộ và chỉ được chạy xe khi không gây nguy hiểm cho người đi bộ."));
        list.add(new Figure(R.drawable.b17, "Biển số 225 \"Trẻ em\"", "báo trước là gần đến đoạn đường thường có trẻ em đi ngang qua hoặc tụ tập trên đường như ở vườn trẻ, trường học, câu lạc bộ"));
        list.add(new Figure(R.drawable.b18, "Biển số 226 \"Đường người đi xe đạp cắt ngang\"", "báo trước là gần tới vị trí thường có người đi xe đạp từ những đường nhỏ cắt ngang qua hoặc từ đường dành cho xe đạp đi nhập vào đường ôtô"));
        list.add(new Figure(R.drawable.b19, "Biển số 234 \"Giao nhau với đường hai chiều\"", "đặt trên đường một chiều, để báo trước sắp đến vị trí giao nhau với đường hai chiều"));
        list.add(new Figure(R.drawable.b20, "Biển số 235 \"Đường đôi\"", "báo trước sắp đến đoạn đường có chiều đi và chiều về phân biệt bằng giải phân cách cứng"));
        list.add(new Figure(R.drawable.b21, "Biển số 236 \"Hết đường đôi\"", "báo trước sắp kết thúc đoạn đường có chiều đi và chiều về phân biệt bằng giải phân cách cứng"));
        list.add(new Figure(R.drawable.b22, "Biển số 242a \"Nơi đường sắt giao vuông góc với đường bộ\"", "bổ sung cho biển số 211 \"Giao nhau với đường sắt không có rào chắn\", để chỉ chỗ đường sắt giao vuông góc đường bộ, và tại chỗ giao nhau đường sắt chỉ có một đường cắt ngang đường bộ"));
        list.add(new Figure(R.drawable.b24, "Biển số 246a \"Chú ý chướng ngại vật - Vòng tránh ra hai bên\"", "báo trước cho lái xe biết phía trước có chướng ngại vật, xe cần giảm tốc độ và đi vòng tránh ra hai bên"));
        list.add(new Figure(R.drawable.b25, "Biển số 246b \"Chú ý chướng ngại vật - Vòng tránh sang bên trái\"", "báo trước cho lái xe biết phía trước có chướng ngại vật, xe cần giảm tốc độ và đi vòng tránh sang bên trái"));
        list.add(new Figure(R.drawable.b26, "Biển số 246c \"Chú ý chướng ngại vật - Vòng tránh sang bên phải\"", "báo trước cho lái xe biết phía trước có chướng ngại vật, xe cần giảm tốc độ và đi vòng tránh sang bên phải"));
        list.add(new Figure(R.drawable.b27,"Biển số 247 \"Chú ý xe đỗ\"","cảnh báo có các loại xe ô tô; máy kéo; rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô hoặc ôtô đầu kéo; xe máy chuyên dùng đang đỗ chiếm một phần đường xe chạy (biển này tương tự, chỉ lộn ngược đầu so với biển báo nguy hiểm số 208 \"Giao nhau với đường ưu tiên\")"));

    }

    @Override
    public void onPause() {
        super.onPause();
        list.clear();
    }
}
