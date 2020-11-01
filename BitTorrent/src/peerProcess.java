import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class peerProcess {
	private static ReadFiles rfObj = null;
	private static ConfigFile configFileReader = null;
	private static Map<Integer,PeerNode> allPeersLHMap = null;
	
	//set peer nodes and add to peerMap
	private static void setPeerNodes(List<String> peerRows)throws Exception{
		allPeersLHMap = new LinkedHashMap<>();
		for(String row:peerRows) {
			PeerNode pnObj = PeerNode.getPeerNodeObject(row);
			int peerId = pnObj.getPeerId();
		//	System.out.println(peerId);		
			allPeersLHMap.put(peerId,pnObj);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		//Read Common.cfg and set the ConfigFile object
		rfObj = ReadFiles.getReadFilesObj();
		List<String> configRows = rfObj.parseTheFile("Common.cfg");
		configFileReader = ConfigFile.getConfigFileObject(configRows);
	//	System.out.println(configFileReader.getNoOfNeighbors());
		
		//Read PeerInfo.cfg and set the PeerNode.java 
		List<String> peerRows = rfObj.parseTheFile("PeerInfo.cfg");
		setPeerNodes(peerRows);

	}

}
