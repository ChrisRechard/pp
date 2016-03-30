package MainTest;
import Connect.BroadcastState;
import org.json.JSONException;

public class CheckTest {

	public static void main(String[] args) throws JSONException {

		String room = "181751";
		boolean isbroadcast = BroadcastState.getState(room);
		if (isbroadcast) {
			BroadcastState.getBambooSum(room);
			BroadcastState.getFansNum(room);
			BroadcastState.getClassification(room);
		}
	}

}
