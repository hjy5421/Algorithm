import java.util.*;

public class stacktest {

}
/*
 * select
 * ifnull(customer_name,"N/A"),ifnull(product_name,"N/A"),ifnull(ii.quantity,0)
 * from customer as c left outer join invoice as i on c.id=i.customer_id left
 * outer join invoice_item as ii on i.id=ii.invoice_id right outer join product
 * as p on ii.product_id=p.id order by c.id,p.id,ii.id;
 */