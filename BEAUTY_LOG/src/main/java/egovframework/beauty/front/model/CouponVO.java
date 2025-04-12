package egovframework.beauty.front.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CouponVO {
    private int couponId;
    private int userSn;
    private String couponType;  // POINT, DISCOUNT, EVENT
    private String couponName;
    private int discountRate;
    private Date createdAt;
}
