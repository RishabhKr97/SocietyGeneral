package society.account.database;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import com.backblaze.b2.client.B2StorageClient;
import com.backblaze.b2.client.B2StorageClientFactory;
import com.backblaze.b2.client.contentSources.B2ContentSource;
import com.backblaze.b2.client.contentSources.B2ContentTypes;
import com.backblaze.b2.client.contentSources.B2FileContentSource;
import com.backblaze.b2.client.exceptions.B2Exception;
import com.backblaze.b2.client.structures.B2UploadFileRequest;
import com.backblaze.b2.client.structures.B2UploadListener;

import society.account.logger.Log;
import society.account.ui.AlertMessages;

public class DatabaseBackup {
	private static final String TAG = "DatabaseBackup";
	private static final String USER_AGENT = "APNA_B2";
	private static final String BUCKET_ID = "B2_BUCKET_ID";
	private static final String DATABASE_FILE = "Database/SocietyGeneral.db";
	private static final String UPLOAD_FILE_NAME = "SocietyGeneral_APNA.db";

	private static JProgressBar backupProgressBar;
	private static JOptionPane backupInformaPane;
	private static JDialog backupInformationDialog;

	public static void backupDatabase(Component component) {
		Log.d(TAG, "Starting Database Backup");

		final B2StorageClient client = B2StorageClientFactory.createDefaultFactory().create(USER_AGENT);
		final B2UploadListener uploadListener = (progress) -> {
			double percent = (100. * (progress.getBytesSoFar() / (double) progress.getLength()));
			if (percent > 10) {
				backupProgressBar.setValue((int) percent);
			} else {
				backupProgressBar.setValue(10);
			}
		};

		B2ContentSource source = B2FileContentSource.build(new File(DATABASE_FILE));
		B2UploadFileRequest request = B2UploadFileRequest
				.builder(getEnvValue(BUCKET_ID), UPLOAD_FILE_NAME, B2ContentTypes.B2_AUTO, source)
				.setListener(uploadListener).build();
		Thread backupThread = new Thread(new BackupTask(client, request, component));

		backupProgressBar = new JProgressBar(0, 100);
		backupProgressBar.setValue(5);
		backupProgressBar.setStringPainted(true);
		backupInformaPane = new JOptionPane();
		backupInformaPane.setMessage("Backup In Progress...");
		backupInformaPane.remove(1);
		backupInformaPane.add(backupProgressBar);
		backupInformationDialog = backupInformaPane.createDialog(component, "Backup Database");
		backupInformationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		backupInformationDialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				if (backupThread.isAlive()) {
					backupThread.interrupt();
				}
				client.close();
			}
		});

		backupThread.start();
		backupInformationDialog.setVisible(true);
	}

	private static String getEnvValue(String key) {
		return System.getenv(key);
	}

	private static class BackupTask implements Runnable {
		B2StorageClient client;
		B2UploadFileRequest request;
		Component component;

		public BackupTask(B2StorageClient client, B2UploadFileRequest request, Component component) {
			this.client = client;
			this.request = request;
			this.component = component;
		}

		@Override
		public void run() {
			try {
				Log.d(TAG, "Backup task starting");
				client.uploadSmallFile(request);
				backupProgressBar.setValue(100);
			} catch (B2Exception e) {
				Log.e(TAG, "Exception while backing up data!", e);
				AlertMessages.showErrorMessage(component, "Error While Backing Up Data");
			} finally {
				Log.d(TAG, "Backup task finished");
				client.close();
				backupInformationDialog.dispose();
			}
		}
	}
}
