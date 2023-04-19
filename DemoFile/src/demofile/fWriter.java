/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demofile;


import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author truong
 */
public class fWriter {

    public static void main(String[] args) {
        File file = new File("D:\\vidu.txt");
        FileWriter writer = null;

        try {
            writer = new FileWriter(file);
            
            String s = "Bài văn xúc động người đọc bởi cảm xúc chân thành từ chính tình cảm của con dành cho người cha tần tảo của mình. Cô giáo đã chấm cho Hậu 9,5 điểm với lời nhận xét: “Em là một người con ngoan, bài viết của em đã làm cho cô rất xúc động. Điều đáng quý nhất của em là tình cảm chân thực và em có một trái tim nhân hậu. Em đã cho cô một bài học làm người. Mong rằng đây không chỉ là trang văn mà còn là sự hành xử của em trong cuộc đời”. Được biết, thầy Lê Trần Bân, hiệu phó trường THPT Huỳnh Thúc Kháng đã đọc bài văn trong lễ chào cờ đầu tuần, trước toàn trường.\n"
                    + "\n"
                    + "Trích đoạn bài văn của em Nguyễn Thị Hậu có những dòng xúc động như sau: “Bố tôi không may mắn như những người đàn ông khác. Trong suốt cuộc đời bố có lẽ không bao giờ được sống trong sự sung sướng, vui vẻ.\n"
                    + "\n"
                    + "Bốn mươi tuổi khi chưa đi được nửa chặng đời người, bố đã phải sống chung với bao nhiêu bệnh tật: Đầu tiên đó chỉ là những cơn đau dạ dày, rồi tiếp đến lại xuất hiện thêm nhiều biến chứng. Trước đây, khi còn khỏe mạnh, bao giờ bố cũng rất phong độ.\n"
                    + "\n"
                    + "Thế nhưng bây giờ, vẻ đẹp ấy dường như đã dần đổi thay: Thay vì những cánh tay cuồn cuộn bắp, giờ đây chỉ còn là một dáng người gầy gầy, teo teo. Đôi mắt sâu dưới hàng lông mày rậm, hai gò má cao cao lại dần nổi lên trên khuôn mặt sạm đen vì sương gió.\n"
                    + "\n"
                    + "Tuy vậy, bệnh tật không thể làm mất đi tính cách bên trong của bố, bố luôn là một người đầy nghị lực, giàu tự tin và hết lòng thương yêu gia đình. Gia đình tôi không khá giả, mọi chi tiêu trong gia đình đều phụ thuộc vào đồng tiền bố mẹ kiếm được hàng ngày”.\n"
                    + "\n"
                    + "Bài văn viết về mẹ\n"
                    + "\n"
                    + "Cũng giống như Nguyễn Thị Hậu, học sinh Nguyễn Thị Kiều Vân viết về người thân trong gia đình đó là mẹ gây xúc động. Bài văn được viết tháng 4/2013 trong tiết kiểm tra môn Ngữ văn khi Kiều Vân học lớp 8. Bài văn được chấm điểm tối đa 10, kèm theo đó là dòng nhận xét “Bài viết quá xúc động, cảm ơn con”.\n"
                    + "\n"
                    + "";
            writer.write(s);
            writer.close();
        } catch (Exception e) {
        }
    }
}
