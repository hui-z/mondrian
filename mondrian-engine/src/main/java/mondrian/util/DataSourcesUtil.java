package mondrian.util;

import mondrian.olap.Util;
import mondrian.xmla.DataSourcesConfig;
import org.apache.log4j.Logger;
import org.eigenbase.xom.DOMWrapper;
import org.eigenbase.xom.Parser;
import org.eigenbase.xom.XOMException;
import org.eigenbase.xom.XOMUtil;

/**
 * @author wanghaibing
 * @date 2019-03-01
 */
public class DataSourcesUtil {

    public static DataSourcesConfig.DataSources parseDataSources(
            String dataSourcesConfigString,
            Logger logger)
    {
        try {
            if (dataSourcesConfigString == null) {
                logger.warn("XmlaSupport.parseDataSources: null input");
                return null;
            }
            dataSourcesConfigString =
                    Util.replaceProperties(
                            dataSourcesConfigString,
                            Util.toMap(System.getProperties()));

            if (logger.isDebugEnabled()) {
                logger.debug(
                        "XmlaSupport.parseDataSources: dataSources="
                                + dataSourcesConfigString);
            }
            final Parser parser =
                    XOMUtil.createDefaultParser();
            final DOMWrapper doc = parser.parse(dataSourcesConfigString);
            return new DataSourcesConfig.DataSources(doc);
        } catch (XOMException e) {
            throw Util.newError(
                    e,
                    "Failed to parse data sources config: "
                            + dataSourcesConfigString);
        }
    }

}
