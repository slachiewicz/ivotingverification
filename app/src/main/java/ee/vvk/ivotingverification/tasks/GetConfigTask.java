package ee.vvk.ivotingverification.tasks;

import ee.vvk.ivotingverification.util.HttpRequest;

public class GetConfigTask extends BaseTask<String> {

    private final AsyncTaskActivity<String> activity;
    private final String url;

    public GetConfigTask(AsyncTaskActivity<String> activity, String url) {
        this.activity = activity;
        this.url = url;
    }

	@Override
    public void setUiForLoading() {
        activity.onPreExecute();
    }

    @Override
    public String call() throws Exception {
        return new HttpRequest().get(url);
    }

    @Override
    public void setDataAfterLoading(String result) {
        activity.onPostExecute(result);
    }

}

