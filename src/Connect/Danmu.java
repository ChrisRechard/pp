package Connect;

public class Danmu {
	public final static String Code = "1";

	public long mTime;// ʱ��

	// ������Ϣ
	public int mQid;
	public String mRoomID;

	// �û��������ߣ���Ϣ
	public String mIdentity;// ���������
	public String mRid; // ������ridֵ
	public String mPlatform;// ������ƽ̨��Ϣ
	public String mNickName;// ����������
	public String mUserName;// �������û���
	public String mLevel; // �����ߵȼ�

	// ��������
	public String mContent;

	public Danmu(long mTime, int mQid, String mRoomID, String mIdentity, String mRid, String mPlatform,
			String mNickName, String mUserName, String mLevel, String mContent) {
		super();
		this.mTime = mTime;
		this.mQid = mQid;
		this.mRoomID = mRoomID;
		this.mIdentity = mIdentity;
		this.mRid = mRid;
		this.mPlatform = mPlatform;
		this.mNickName = mNickName;
		this.mUserName = mUserName;
		this.mLevel = mLevel;
		this.mContent = mContent;
	}

	public Danmu() {
		super();
	}

}
