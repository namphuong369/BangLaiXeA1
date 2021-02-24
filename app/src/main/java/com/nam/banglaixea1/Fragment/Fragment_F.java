package com.nam.banglaixea1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nam.banglaixea1.Adapter.FigureBAdapter;
import com.nam.banglaixea1.Module.Figure;
import com.nam.banglaixea1.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_F extends Fragment {
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
        list.add(new Figure(R.drawable.f1, "Biển số 401 \"Bắt đầu đường ưu tiên\"", "Để biểu thị ưu tiên cho các phương tiện trên đường có đặt biển này được đi trước. Biển đặt tại vị trí thích hợp trước khi đường nhánh sắp nhập vào trục đường chính, yêu cầu phương tiện từ đường nhánh ra phải dừng lại nhường cho phương tiện trên đường chính đi trước. "));
        list.add(new Figure(R.drawable.f2, "Biển số 402 \"Hết đoạn đường ưu tiên\"", "Báo hiệu hết đoạn đường được ưu tiên"));
        list.add(new Figure(R.drawable.f3, "Biển số 403a \"Đường dành cho ôtô\"", "Để chỉ dẫn bắt đầu đường dành cho các loại ôtô đi lại, các loại phương tiện giao thông khác không được phép đi vào đoạn đường có dặt biển này"));
        list.add(new Figure(R.drawable.f4, "Biển số 403b “Đường dành cho ô tô, xe máy\"", "Để chỉ dẫn bắt đầu đường dành cho các loại ôtô, xe máy (kể cả xe gắn máy) đi lại, các loại phương tiện giao thông khác không được phép đi vào đoạn đường có đặt biển này"));
        list.add(new Figure(R.drawable.f5, "Biển số 404a \"Hết đường dành cho ô tô\"", "Để chỉ dẫn hết đoạn đường dành cho ôtô đi lại"));
        list.add(new Figure(R.drawable.f6, "Biển số 404b \"Hết đường dành cho ô tô, xe máy\"", "Để chỉ dẫn hết đoạn đường dành cho ôtô, xe máy đi lại"));
        list.add(new Figure(R.drawable.f7, "Biển số 405c \"Đường cụt\"", "Để chỉ dẫn phía trước là đường cụt, đặt trước đường cụt 300m đến 500m và cứ 100m phải đặt thêm một biển"));
        list.add(new Figure(R.drawable.f8, "Biển số 406 \"Được ưu tiên qua đường hẹp\" ", "Để chỉ dẫn cho người lái xe cơ giới biết mình được quyền ưu tiên đi trước trên đoạn đường hẹp. Nếu trên hướng đi ngược chiều có xe (cơ giới hoặc thô sơ) đã đi vào phạm vi đường hẹp thì xe đi theo chiều ưu tiên cũng phải nhường đường."));
        list.add(new Figure(R.drawable.f9, "Biển số 407a \"Đường một chiều\" ", "Để chỉ dẫn những đoạn đường chạy một chiều. Biển số 407a đặt sau nơi đường giao nhau"));
        list.add(new Figure(R.drawable.f10, "Biển số 407b \"Đường một chiều\" ", "Để chỉ dẫn những đoạn đường chạy một chiều. Biển số 407b đặt sau nơi đường giao nhau"));
        list.add(new Figure(R.drawable.f11, "Biển số 407c \"Đường một chiều\"", "Để chỉ dẫn những đoạn đường chạy một chiều. Biển số 407c đặt sau nơi đường giao nhau"));
        list.add(new Figure(R.drawable.f12, "Biển số 408 \"Nơi đỗ xe\" ", "Để chỉ dẫn những nơi được phép đỗ xe, những bãi đỗ xe, bến xe v.v..."));
        list.add(new Figure(R.drawable.f13, "Biển số 409 \"Chỗ quay xe\" ", "Để chỉ dẫn vị trí được phép quay đầu xe. Biển không cho phép rẽ trái (trừ các xe được quyền ưu tiên theo quy định)."));
        list.add(new Figure(R.drawable.f14, "Biển số 410 \"Khu vực quay xe\" ", "Để chỉ dẫn khu vực được phép quay đầu xe , phải đặt biển số 410 \"Khu vực quay xe\". Trên biển mô tả cách thức tiến hành quay xe. Biển không cho phép rẽ trái (trừ các xe được quyền ưu tiên theo quy định)."));
        list.add(new Figure(R.drawable.f15, "Biển số 411 \"Hướng đi trên mỗi làn đường theo vạch kẻ đường\" ", "Để chỉ dẫn cho người lái xe biết số lượng làn đường trên mặt đường và hướng đi trên mỗi làn đường theo vạch kẻ đường."));
        list.add(new Figure(R.drawable.f16, "Biển số 412d \"Làn đường dành riêng cho xe môtô\" ", "Để chỉ dẫn cho người lái xe biết có làn đường dành riêng cho từng loại xe riêng biệt."));
        list.add(new Figure(R.drawable.f17, "Biển số 413a \"Đường có làn đường dành cho ô tô khách\"", "Để chỉ dẫn cho người lái xe biết đường có làn đường dành riêng cho ôtô khách theo chiều ngược lại"));
        list.add(new Figure(R.drawable.f18, "Biển số 413b \"Rẽ ra đường có làn đường dành cho ô tô khách\"", "Để chỉ dẫn cho người lái xe biết ở nơi đường giao nhau rẽ phải hoặc rẽ trái là rẽ ra đường có làn đường dành cho ôtô khách"));
        list.add(new Figure(R.drawable.f19, "Biển số 414a \"Chỉ hướng đường\" ", "Biển số 414a đặt ở nơi đường giao nhau và chỉ có một địa danh và khu dân cư trên hướng đường cần phải chỉ dẫn. "));
        list.add(new Figure(R.drawable.f20, "Biển số 416 \"Lối đi đường vòng tránh\"", "Đặt trước các đường giao nhau, để chỉ dẫn lối đi đường tránh, đường vòng trong trường hợp đường chính bị tắc, hoặc đường chính cấm một số loại xe đi qua"));
        list.add(new Figure(R.drawable.f21, "Biển số 418 \"Lối đi ở những vị trí cấm rẽ\" ", "Để chỉ lối đi ở các nơi đường giao nhau bị cấm rẽ. Biển được đặt ở nơi đường giao nhau trước đường cấm rẽ. "));
        list.add(new Figure(R.drawable.f22, "Biển số 420 \"Bắt đầu khu đông dân cư\" ", "Để chỉ dẫn bắt đầu vào phạm vi khu đông dân cư, người sử dụng đường biết phạm vi phải tuân theo những quy định đi đường được áp dụng ở khu đông dân cư."));
        list.add(new Figure(R.drawable.f23, "Biển số 421 \"Hết khu đông dân cư\" ", "Để chỉ dẫn hết phạm vi khu đông dân cư, người sử dụng đường biết phạm vi phải tuân theo những quy định đi đường được áp dụng ở khu đông dân cư đã hết hiệu lực."));
        list.add(new Figure(R.drawable.f24, "Biển số 423a \"Đường người đi bộ sang ngang\" ", "Để chỉ dẫn cho người đi bộ và người lái xe biết nơi dành cho người đi bộ sang ngang. Biển này được sử dụng độc lập ở những vị trí sang ngang, đường không có tổ chức điều khiển giao thông hoặc có thể sử dụng phối hợp với vạch kẻ đường. Gặp biển này người lái xe phải điều khiển xe chạy chậm, chú ý quan sát, ưu tiên cho người đi bộ sang ngang."));
        list.add(new Figure(R.drawable.f25, "Biển số 424a\"Cầu vượt qua đường cho người đi bộ\"", "Để chỉ dẫn cho người đi bộ sử dụng cầu vượt qua đường"));
        list.add(new Figure(R.drawable.f26, "Biển số 424c \"Hầm chui qua đường cho người đi bộ\" ", "Để chỉ dẫn cho người đi bộ sử dụng hầm chui qua đường."));
        list.add(new Figure(R.drawable.f27, "Biển số 425 \"Bệnh viện\" ", "Để chỉ dẫn sắp đến cơ sở điều trị bệnh ở gần đường như bệnh viện, bệnh xá, trạm xá v.v... Gặp biển này người lái xe đi chậm, chú ý quan sát và không sử dụng còi."));
        list.add(new Figure(R.drawable.f28, "Biển số 426 \"Trạm cấp cứu\" ", "Để chỉ dẫn nơi có trạm cấp cứu y tế ở gần đường"));
        list.add(new Figure(R.drawable.f29, "Biển số 446 \"Nơi đỗ xe dành cho người tàn tật\" ", "Để báo hiệu nơi đỗ xe dành cho người tàn tật"));
        list.add(new Figure(R.drawable.f30,"Biển số 447 \"Biển báo cầu vượt liên thông\"","Biển đặt tại vị trí trước khi vào cầu vượt có tổ chức giao thông liên thông giữa các tuyến. "));
    }

    @Override
    public void onPause() {
        super.onPause();
        list.clear();
    }
}
