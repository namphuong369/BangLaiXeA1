package com.nam.banglaixea1.Fragment;

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

public class Fragment_E extends Fragment {
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
        list.add(new Figure(R.drawable.e1, "Vạch số 1.1", "Vạch liền nét màu trắng, rộng 10cm, Phân chia 2 dòng phương tiện giao thông đi ngược chiều nhau, xe không được đè lên vạch."));
        list.add(new Figure(R.drawable.e2, "Vạch số 1.2", "Vạch liền nét màu trắng, rộng 20cm, Xác định mép phần xe cơ giới với phần xe thô sơ, người  đi bộ hoặc lề đường trên các trục đường, xe chạy được phép đè lên vạch khi cần thiết."));
        list.add(new Figure(R.drawable.e3, "Vạch số 1.3", "Hai vạch liên tục màu trắng (vạch kép) có chiều rộng bằng nhau và bằng 10cm cách nhau là 10cm tính từ 2 mép vạch kề nhau, phân  chia  2  dòng  phương  tiện  giao  thông  đi  ngược chiều nhau trên những đường có từ 4 làn xe trở lên, xe không được đè lên vạch"));
        list.add(new Figure(R.drawable.e4, "Vạch số 1.4", "Vạch liên tục màu vàng có chiều rộng 10cm, xác định nơi cấm dừng và cấm đỗ xe, áp dụng độc lập hoặc có thể kết hợp với biển báo cấm số 130 \"Cấm dừng xe và đỗ xe\" và kẻ ở mép đường hay ở trên hàng vỉa nơi có vỉa hè"));
        list.add(new Figure(R.drawable.e5, "Vạch số 1.5", "Vạch đứt quãng màu trắng, rộng 10cm, phân chia 2 dòng phương tiện giao thông đi ngược chiều nhau trên những đường có 2 hoặc 3 làn xe chạy hoặc xác định danh giới làn xe khi có từ 2 làn xe trở lên chạy theo một chiều"));
        list.add(new Figure(R.drawable.e6, "Vạch số 1.6", "Vạch đứt quãng màu trắng, rộng 10cm, là vạch báo hiệu chuẩn bị đến Vạch số 1.1 hay Vạch số 1.11 dùng để phân chia dòng xe ngược chiều hay cùng chiều."));
        list.add(new Figure(R.drawable.e7, "Vạch số 1.7", "Vạch đứt quãng màu trắng, rộng 10cm, khoảng cách giữa hai vạch bằng chiều dài của vạch là 50cm. Vạch được kẻ theo đường cong để dẫn hướng rẽ ở chỗ đường giao nhau cho lái xe, để bảo đảm an toàn."));
        list.add(new Figure(R.drawable.e8, "Vạch số 1.8", "Vạch đứt quãng màu  trắng, rộng 40cm dài 100cm, khoảng cách giữa hai vạch là 300cm. Dùng để quy định ranh giới giữa làn xe tăng tốc độ hoặc giảm tốc độ (gọi là làn đường chuyển tốc) với làn xe chính của phần xe chạy, được kẻ ở nơi giao nhau, nhằm dẫn hướng cho xe tách nhập làn an toàn."));
        list.add(new Figure(R.drawable.e9, "Vạch số 1.9", "Hai vạch liên tiếp (vạch kép) đứt quãng song song màu trắng, rộng 10cm, quy định ranh giới làn xe dự trữ để tăng làn xe cho chiều xe có lưu lượng lớn. Trên làn đường này có điều khiển thay đổi hướng xe bằng đèn tín hiệu xanh và đỏ."));
        list.add(new Figure(R.drawable.e10, "Vạch số 1.10", "Vạch đứt quãng màu vàng, rộng 10cm, dài 100cm và cách nhau 100cm. Xác định vị trí hay khu vực cấm đỗ xe (áp dụng độc lập hay kết hợp với biển báo cấm số 131a “Cấm đỗ xe”), được kẻ ở mép mặt đường hay trên hàng vỉa nơi có vỉa hè."));
        list.add(new Figure(R.drawable.e11, "Vạch số 1.11", "Hai vạch song song màu trắng, một vạch liên tục và một vạch đứt quãng chiều rộng bằng nhau bằng 10cm, hai mép liên tiếp cách nhau 10cm, để phân chia dòng phương tiện 2 hướng ngược chiều nhau trên các đường có 2 hoặc 3 làn xe chạy. Lái xe bên vạch đứt quảng được phép đè lên vạch để vượt xe."));
        list.add(new Figure(R.drawable.e12, "Vạch số 1.12", "Vạch liên tục màu trắng có chiều rộng 40cm, kẻ ngang mặt đường, chỉ rõ vị trí mà lái xe phải dừng lại khi có tín hiệu đèn đỏ, hoặc biển báo số 122 \"STOP\"."));
        list.add(new Figure(R.drawable.e13, "Vạch số 1.13", "Vạch hình tam giác cân màu trắng, chỉ rõ vị trí mà lái xe phải dừng để nhường cho các phương tiện khác ở đường ưu tiên."));
        list.add(new Figure(R.drawable.e14, "Vạch số 1.14", "Vạch \"Sọc ngựa vằn\" dùng quy định nơi người đi bộ qua đường bao gồm các vạch song song với trục tim đường màu trắng chiều rộng 40cm, cách nhau 60cm "));
        list.add(new Figure(R.drawable.e15, "Vạch số 1.15", "Xác định vị trí dành cho xe đạp đi cắt ngang qua đường đi của xe cơ giới. Ở nơi đường giao nhau không có người, tín hiệu điều khiển giao thông thì xe đạp phải nhường đường cho phương tiện cơ giới chạy trên đường cắt ngang đường xe đạp."));
        list.add(new Figure(R.drawable.e16, "Vạch số 1.16.1", "Vạch \"ngựa vằn\" ở trong chạy cắt chéo góc nhọn thành những tam giác, xác định đảo phân chia dòng phương tiện ngược chiều nhau."));
        list.add(new Figure(R.drawable.e17, "Vạch số 1.16.2", "Vạch ở trong hình gãy khúc có đỉnh nằm trên đường phân giác của góc nhọn cùng chiều với góc nhọn, xác định đảo phân chia dòng phương tiện theo cùng một hướng."));
        list.add(new Figure(R.drawable.e18, "Vạch số 1.16.3", "Vạch ở trong hình gãy khúc có đỉnh nằm trên đường phân giác ngược chiều với góc nhọn, xác định đảo nhập dòng phương tiện"));
        list.add(new Figure(R.drawable.e19, "Vạch số 1.17", "Vạch liên tục gãy khúc màu vàng (có dạng hình chữ M, nhiều đỉnh), quy định vị trí dừng xe của các phương tiện vận tải hành khách công cộng chạy theo tuyến quy định hoặc nơi tập kết của tắc -xi"));
        list.add(new Figure(R.drawable.e20, "Vạch số 1.18", "Vạch hình các mũi tên màu trắng, chỉ dẫn hướng đi cho phép của từng làn xe ở nơi giao nhau. Vạch này vẽ trước nơi giao nhau ở từng làn riêng bắt buộc lái xe phải tuân theo mũi tên chỉ hướng đi."));
        list.add(new Figure(R.drawable.e21, "Vạch số 1.19", "Vạch hình các mũi  tên màu trắng, xác định sắp đến gần đoạn đường bị thu hẹp phần đường xe chạy, số làn xe theo hướng mũi tên bị giảm và lái xe phải từ từ chuyển làn đi theo mũi tên."));
        list.add(new Figure(R.drawable.e22, "Vạch số 1.20", "Vạch hình tam giác màu trắng cao 4m, rộng của đáy tam giác là 1,6m, xác định khoảng cách còn 2m-25m đến vạch 1.13 và biển số 208 “Giao nhau với đường ưu tiên”."));
        list.add(new Figure(R.drawable.e23, "Vạch số 1.21", "Vạch này là chữ \"STOP\" (Dừng lại) xác định gần đến vị trí dừng lại Vạch số 1.12 và biển số 122  “Dừng  lại”. Vạch số 1.21 cách vạch dừng xe từ 2 đến 25m."));
        list.add(new Figure(R.drawable.e24,"Vạch số 1.22","Là số hiệu của đường, được kẻ trên đường quốc lộ, và kẻ trực tiếp trên mặt đường phần xe chạy. "));
        list.add(new Figure(R.drawable.e25,"Vạch số 1.23","Vạch này màu trắng hình chữ A, dùng để quy định làn xe dành cho ôtô khách chạy theo tuyến quy định, kẻ trực tiếp trên làn xe dành riêng. "));
    }

    @Override
    public void onPause() {
        super.onPause();
        list.clear();
    }

}
