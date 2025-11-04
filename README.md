#  Install OpenJDK:
sudo apt install -y openjdk-17-jdk
java -version   # verify

#  install Maven:
sudo apt install -y maven
mvn -v

# Install MySQL server + client:
sudo apt install -y mysql-server mysql-client
sudo systemctl enable --now mysql
sudo mysql_secure_installation   # run through the interactive secure setup

# Install MySQL Workbench (GUI):
sudo apt install -y mysql-workbench

# Install IntelliJ IDEA:
sudo snap install intellij-idea-community --classic

# Clone the repo
cd ~/projects || mkdir -p ~/projects && cd ~/projects
git clone https://github.com/MdZahidulIslam-Bismi/family-backend.git
cd family-backend
ls -la

# Create MySQL database and user for the app:
sudo mysql -u root -p

# than:

CREATE DATABASE family CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'family_user'@'localhost' IDENTIFIED BY 'strong_password';
GRANT ALL PRIVILEGES ON family.* TO 'family_user'@'localhost';
FLUSH PRIVILEGES;
EXIT;
