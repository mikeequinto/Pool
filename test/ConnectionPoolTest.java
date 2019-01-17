
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class ConnectionPoolTest {


    @Test
    public void initTest() {
        PoolConfig poolConf = new PoolConfig(10,"urlPool","loginPool","passwordPool");
        ConnectionPool connPool = new ConnectionPool(poolConf);
        Assert.assertEquals(connPool.getLstConnection().size(),10);
    }

    @Test
    public void accesBddBonTest() throws SQLException {
        PoolConfig poolConf = new PoolConfig(10,"urlPool","loginPool","passwordPool");
        ConnectionPool connPool = new ConnectionPool(poolConf);
        boolean connectionsBonnes = true;
        for (int i = 0; connPool.getLstConnection().size()>i;i++)
        {
            connPool.getLstConnection().get(i).getSecond().getConnection();
        }
        Assert.assertEquals(connectionsBonnes,true);
    }


    @Test
    public void connectionNoneAvailableTest() {
        PoolConfig poolConf = new PoolConfig(10,"urlPool","loginPool","passwordPool");
        ConnectionPool connPool = new ConnectionPool(poolConf);
        connPool.getConnection();
        int nbCoNoneAvailable = 0;
        for (int i = 0; connPool.getLstConnection().size()>i;i++)
        {
            if(connPool.getLstConnection().get(i).getFirst())
            {
                nbCoNoneAvailable++;
            }
        }
        Assert.assertEquals(nbCoNoneAvailable,1);
    }


    @Test
    public void connectionAvailableTest() {
        PoolConfig poolConf = new PoolConfig(10,"urlPool","loginPool","passwordPool");
        ConnectionPool connPool = new ConnectionPool(poolConf);
        connPool.getConnection();
        int nbCoNoneAvailable = 0;
        for (int i = 0; connPool.getLstConnection().size()>i;i++)
        {
            if(!connPool.getLstConnection().get(i).getFirst())
            {
                nbCoNoneAvailable++;
            }
        }
        Assert.assertEquals(nbCoNoneAvailable,9);
    }

}
